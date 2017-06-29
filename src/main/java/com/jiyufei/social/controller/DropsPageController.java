package com.jiyufei.social.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 *Created by jiyufei on 2016年11月3日 下午2:39:24 .
 */
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DropsPageController {

	
	@RequestMapping("showDrops.htm")
	public ModelAndView showDropsPage(Integer id){
		ModelAndView modelAndView = new ModelAndView("showDrops");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@RequestMapping("wyDrops.htm")
	public ModelAndView wyDropsPage(){
		ModelAndView modelAndView = new ModelAndView("wyDrops");
		
		return modelAndView;
	}
	
}
