package template.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import template.framework.objects.UserOptions;

@Controller
public class MainController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) 
	{
		model.addAttribute("index", new UserOptions());
		return "index";
	}
	
/*	@RequestMapping(value="/map", method=RequestMethod.POST)
	public String formSubmit() 
	{

		return "map";
	}
	
*/	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String formSubmit(@ModelAttribute UserOptions userOptions, Model model)
	{
		model.addAttribute("index", userOptions);
		return "map";
	}
}
