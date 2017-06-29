package com.jiyufei.social.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiyufei.social.bean.LoginUser;
import com.jiyufei.social.bean.SocialHistory;
import com.jiyufei.social.bean.SocialRecord;
import com.jiyufei.social.bean.WyDrops;
import com.jiyufei.social.service.LoginUserService;
import com.jiyufei.social.service.SocialHistoryService;
import com.jiyufei.social.service.SocialRecordService;
import com.jiyufei.social.service.WyDropsService;
import com.jiyufei.social.util.DropsHistory;

/*
 *Created by jiyufei on 2016年10月28日 上午9:36:17 .
 */
@Controller
public class LoginPageController {

	@Autowired
	private LoginUserService loginUserService;
	@Autowired
	private SocialRecordService socialRecordService;
	@Autowired
	private SocialHistoryService socialHistoryService;
	@Autowired
	private WyDropsService wyDropsService;
	
	Log info = LogFactory.getLog("info");
	Log error = LogFactory.getLog("error");
	
	@RequestMapping(value="index.htm")
	public ModelAndView indexPage(HttpServletRequest request){
		String username = null;
		int userId = 0;
		ModelAndView modelAndView = new ModelAndView("index");
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = userDetails.getUsername();
		try {
			LoginUser loginUser = loginUserService.getUserByMail(email);
			username = loginUser.getUsername();
			userId = loginUser.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("userId", userId);
		try {
			SocialRecord socialRecord = socialRecordService.getRecord();
			if(socialRecord == null){
				info.info("[LoginPageController.indexPage]socialRecord 为 null");
			}
			modelAndView.addObject("socialRecord", socialRecord);
			List<SocialHistory> socialHistories = socialHistoryService.getHistory();
			modelAndView.addObject("history", socialHistories);
			List<WyDrops> wyDropsList = wyDropsService.getDropsTop10();
			Iterator<WyDrops> iterator = wyDropsList.iterator();
			List<DropsHistory> dropsHistoriyList = new ArrayList<DropsHistory>();
			WyDrops drops = null;
			while(iterator.hasNext()){
				drops = (WyDrops)iterator.next();
				DropsHistory history = new DropsHistory(drops);
				dropsHistoriyList.add(history);
			}
			modelAndView.addObject("dropsHistory", dropsHistoriyList);
		} catch (Exception e) {
			error.error("[LoginPageController.indexPage]", e);
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="login.htm")
	public ModelAndView loginPage(){
		ModelAndView modelAndView;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken){
			modelAndView = new ModelAndView("login");
		}else{
			modelAndView = new ModelAndView("redirect:/index.htm");
		}
		return modelAndView;
	}
	
}
