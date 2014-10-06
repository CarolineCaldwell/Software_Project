package template.controllers;


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
	public String formSubmit( UserOptions userOptions, Model a)
	{
		if (userOptions.isNotValid()) 
		{
			return "index";
	    }
		UserOptions test = new UserOptions();
		test.setAge("derp");
		test.setIncome("town");
		test.setLocationName("dingle");
		test.setCommunityType("berry");
		test.setRelationshipStatus("dunkey");
		test.setSchoolImportance("fuck");
		
		a.addAttribute("test", test);
		System.out.println(userOptions.getLocationName());
		System.out.println(userOptions.getIncome());
		System.out.println(userOptions.getRelationshipStatus());
		System.out.println(userOptions.getAge());
		System.out.println(userOptions.getCommunityType());
		System.out.println(userOptions.getSchoolImportance());
		return "results";
	}
}
