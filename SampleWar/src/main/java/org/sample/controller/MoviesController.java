package org.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesController {
	
	@RequestMapping(value="/mvc/view", method={RequestMethod.GET})
	public ModelAndView movieHandler(){
		ModelAndView model = new ModelAndView("view");
//		model.addObject("titles", "Movie Title");
//		model.
		return model;
		
	}

}
