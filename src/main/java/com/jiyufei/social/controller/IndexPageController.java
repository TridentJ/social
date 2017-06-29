package com.jiyufei.social.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*
 *Created by jiyufei on 2016年11月1日 下午1:44:14 .
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiyufei.social.bean.SocialCount;
import com.jiyufei.social.bean.WyCount;
import com.jiyufei.social.service.SocialCountService;
import com.jiyufei.social.service.WyCountService;
import com.jiyufei.social.util.AjaxResponse;
import com.jiyufei.social.util.SocialCountString;
import com.jiyufei.social.util.WyCountString;

@Controller
public class IndexPageController {

	@Autowired
	private SocialCountService socialCountService;
	@Autowired
	private WyCountService wyCountService;
	
	Log error = LogFactory.getLog("error");
	
	@ResponseBody
	@RequestMapping(value="getSocialCount.htm",method=RequestMethod.POST)
	public AjaxResponse getSocialCount(){
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			List<SocialCount> socialCountList = socialCountService.getSocialCount();
			if(socialCountList == null){
				error.error("[IndexPageController.getSocialCount]获取查询数量记录为空");
				ajaxResponse.setCode(new Integer(200));
				ajaxResponse.setMsg("获取社工库查询记录为空");
			}else{
				List<SocialCountString> socialCountStringList = new ArrayList<SocialCountString>();
				SocialCount socialCount = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				/*
				Iterator<SocialCount> socialIterator = socialCountList.iterator();
				while(socialIterator.hasNext()){
					socialCount = (SocialCount)socialIterator.next();
					SocialCountString socialCountString = new SocialCountString();
					socialCountString.setNum(socialCount.getNum());
					socialCountString.setDate(sdf.format(socialCount.getDate()));
					socialCountStringList.add(socialCountString);
				}
				*/
				for(int i = socialCountList.size()-1;i >= 0;i--){
					socialCount = socialCountList.get(i);
					SocialCountString socialCountString = new SocialCountString();
					socialCountString.setNum(socialCount.getNum());
					socialCountString.setDate(sdf.format(socialCount.getDate()));
					socialCountStringList.add(socialCountString);
				}
				ajaxResponse.setCode(new Integer(0));
				ajaxResponse.setMsg("ok");
				ajaxResponse.setContent(socialCountStringList);
			}
		} catch (Exception e) {
			error.error("[IndexPageController.getSocialCount]",e);
			ajaxResponse.setCode(new Integer(108));
			ajaxResponse.setMsg("操作失败");
		}
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="getWyCount.htm",method=RequestMethod.POST)
	public AjaxResponse getWyCount(){
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			List<WyCount> wyCountList = wyCountService.getWyCount();
			if(wyCountList == null){
				error.error("[IndexPageController.getWyCount]获取阅读数量记录为空");
				ajaxResponse.setCode(new Integer(201));
				ajaxResponse.setMsg("获取知识库阅读记录为空");
			}else{
				List<WyCountString> wyCountStringList = new ArrayList<WyCountString>();
				WyCount wyCount = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				/*
				Iterator<WyCount> wyIterator = wyCountList.iterator();
				while (wyIterator.hasNext()) {
					wyCount = (WyCount)wyIterator.next();
					WyCountString wyCountString = new WyCountString();
					wyCountString.setNum(wyCount.getNum());
					wyCountString.setDate(sdf.format(wyCount.getDate()));
					wyCountStringList.add(wyCountString);
				}
				*/
				//反向遍历
				for(int i = wyCountList.size()-1;i >= 0;i--){
					wyCount = wyCountList.get(i);
					WyCountString wyCountString = new WyCountString();
					wyCountString.setNum(wyCount.getNum());
					wyCountString.setDate(sdf.format(wyCount.getDate()));
					wyCountStringList.add(wyCountString);
				}
				ajaxResponse.setCode(new Integer(0));
				ajaxResponse.setMsg("ok");
				ajaxResponse.setContent(wyCountStringList);
			}
		} catch (Exception e) {
			error.error("[IndexPageController.getWyCount]",e);
			ajaxResponse.setCode(new Integer(108));
			ajaxResponse.setMsg("操作失败");
		}
		return ajaxResponse;
	}
	
}
