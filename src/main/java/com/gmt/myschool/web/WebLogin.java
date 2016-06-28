package com.gmt.myschool.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebLogin {

	    @RequestMapping(value="/validate", method=RequestMethod.POST)
	    public String validate(@Valid Data data, 
	    		BindingResult bindingResult, 
	    		Model model ) {
	        
	        return "home";
	    }
}
