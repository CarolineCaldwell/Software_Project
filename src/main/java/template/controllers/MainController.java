package template.controllers;


import java.io.IOException;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestParam;

import template.controllers.*;
import template.framework.objects.UserOptions;

@Controller 
public class MainController extends WebMvcConfigurerAdapter {
	
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
        registry.addViewController("/results").setViewName("results");
    }*/
	
	
	
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
		
		a.addAttribute("info", info);
		
		return "results";
	}
}
