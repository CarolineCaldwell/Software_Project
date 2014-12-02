/*	File Name:		Main Controller.java
 * 	Author:			Unknown
 * 	Description:	
 * 	
 */

package template.controllers;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestParam;

import template.algorithm.AlgorithmController;
import template.algorithm.ApiImportance;
import template.algorithm.ApiResults;
import template.api.AgeAPIPage;
import template.api.EducationAPIPage;
import template.api.IncomeAPIPage;
import template.api.LocationAPIPage;
import template.api.LocationFCCPage;
import template.api.LocationToMap;
import template.api.MarriedAPIPage;
import template.framework.objects.Info;
import template.framework.objects.UserOptions;
import template.parsers.*;

@Controller 
public class MainController extends WebMvcConfigurerAdapter {
	
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
        registry.addViewController("/results").setViewName("results");
    }*/
	
	@ModelAttribute("ratings")
	public List<int[]> populateRatings()
	{
		int[] temp = new int[]{1,2,3,4,5};
		return Arrays.asList(temp);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(UserOptions userOptions) 
	{
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String formSubmit( UserOptions userOptions, Model a) throws JSONException, IOException
	{
		if (userOptions.isNotValid()) 
		{
			return "invalid";
	    }
		//return "redirect:/results";
		System.out.println(userOptions.getLocationName());
		System.out.println(userOptions.getIncome());
		System.out.println(userOptions.getRelationshipStatus());
		System.out.println(userOptions.getAge());
		System.out.println(userOptions.getCommunityType());
		
		System.out.println(userOptions.getIncomeImportance());
		System.out.println(userOptions.getRelationshipStatusImportance());
		System.out.println(userOptions.getAgeImportance());
		System.out.println(userOptions.getCommunityTypeImportance());
		System.out.println(userOptions.getSchoolImportance());
		
		Info info = new Info();
		LocationAPIPage apiLatCall = new LocationAPIPage();
		LocationFCCPage apiFIPSCall = new LocationFCCPage();
		IncomeAPIPage apiIncomeCall = new IncomeAPIPage();
		AgeAPIPage apiAgeCall = new AgeAPIPage();
		MarriedAPIPage apiMarriedCall = new MarriedAPIPage();
		EducationAPIPage apiEducationCall = new EducationAPIPage();
		
		info = apiLatCall.callGeocoding(userOptions);
		apiFIPSCall.callFCC(info);
		apiIncomeCall.callIncome(info, userOptions);
		apiAgeCall.callAge(info, userOptions);
		apiMarriedCall.callMarried(info, userOptions);
		apiEducationCall.callEducation(info, userOptions);
		
		IncomeParser incomeParser = new IncomeParser();
		AgeParser ageParser = new AgeParser();
		MarriedParser marriedParser = new MarriedParser();
		EducationParser educationParser = new EducationParser();
		AreaParser areaParser = new AreaParser();
		
		ApiResults apiResults [] = incomeParser.parseIncome(info);
		ageParser.parseAge(info, apiResults);
		marriedParser.parseMarried(info, apiResults);
		educationParser.parseEducation(info, apiResults);		
		areaParser.parseArea(apiResults);
		
//Start Algorithm		
		AlgorithmController algorithmController = new AlgorithmController();
		ApiImportance apiStatic = new ApiImportance(userOptions);
		
		//call algorithm
		for(int i = 0; i < apiResults.length; i++)
		{
			algorithmController.generateAlgorithm(apiResults[i], apiStatic);
		}
//End Algorithm
				
		Arrays.sort(apiResults);
		int numPoints = 50;
		ApiResults topResults[] = new ApiResults [numPoints];
		
		for (int b = 0; b < numPoints; b++) {
			ApiResults temp = new ApiResults();
			temp.copyResult(apiResults[b]);
			topResults[b] = temp;
		}
		
		LocationToMap locationToMap = new LocationToMap();
		locationToMap.mapToLocation(info, topResults);
		
		double totalValue = 0;
		
		double[] heatMapInfo = new double[numPoints * 3];
		int index = 0;
		
		for(int k = 0; k < numPoints; k++)
		{
			heatMapInfo[index] = topResults[k].getCenterY();
			heatMapInfo[index + 1] = topResults[k].getCenterX();
			heatMapInfo[index + 2] = topResults[k].getAlgorithmValue() * 100;
			index+=3;
			totalValue += topResults[k].getRadius();
			
		}
		System.out.println("USE THIS RADIUS IN M: " + (totalValue / topResults.length));
		
		a.addAttribute("heatMapInfo", heatMapInfo);
		
		return "map";
	}
}
