package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("test")
	public ModelAndView test(ModelAndView mv) {
		mv.setViewName("/test");
		return mv;
	}
}
