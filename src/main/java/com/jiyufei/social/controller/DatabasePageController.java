package com.jiyufei.social.controller;

import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 *Created by jiyufei on 2016年10月28日 下午1:57:59 .
 */
@Controller
public class DatabasePageController {
	
	
	@RequestMapping(value="searchMail.htm")
	public ModelAndView SearchMailPage(String search){
		ModelAndView modelAndView = new ModelAndView("searchMail");
		modelAndView.addObject("search", search);
		return modelAndView;
	}
	
	@RequestMapping(value="searchPhone.htm")
	public ModelAndView SearchPhonePage(String search){
		ModelAndView modelAndView = new ModelAndView("searchPhone");
		modelAndView.addObject("search", search);
		return modelAndView;
	}
	
	@RequestMapping(value="searchId.htm")
	public ModelAndView SearchIdPage(String search){
		ModelAndView modelAndView = new ModelAndView("searchId");
		modelAndView.addObject("search", search);
		return modelAndView;
	}
	
	@RequestMapping(value="searchName.htm")
	public ModelAndView SearchNamePage(String search){
		ModelAndView modelAndView = new ModelAndView("searchName");
		String content = null;
		if(search != null){
			try {
				content = new String(search.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				content = "";
			}
		}
		modelAndView.addObject("search", content);
		return modelAndView;
	}
	
	@RequestMapping(value="searchDetail.htm")
	public ModelAndView searchDetail(String content,Integer type){
		ModelAndView modelAndView = null;
		if(type == 1){
			modelAndView = new ModelAndView("redirect:/searchMail.htm?search=" + content);
		}else if(type == 3){
			modelAndView = new ModelAndView("redirect:/searchId.htm?search=" + content);
		}else if(type == 4){
			modelAndView = new ModelAndView("redirect:/searchName.htm?search=" + content);
		}else if(type == 2){
			modelAndView = new ModelAndView("redirect:/searchPhone.htm?search=" + content);
		}else{
			modelAndView = new ModelAndView("redirect:/404.htm");
		}
		return modelAndView;
	}
}
