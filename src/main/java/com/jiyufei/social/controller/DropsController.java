package com.jiyufei.social.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiyufei.social.bean.WyDrops;
import com.jiyufei.social.service.WyCountService;
import com.jiyufei.social.service.WyDropsService;
import com.jiyufei.social.util.AjaxResponse;
import com.jiyufei.social.util.WyDropsResponse;

/*
 *Created by jiyufei on 2016年11月3日 下午2:43:13 .
 */
@Controller
public class DropsController {
	
	@Autowired
	private WyDropsService wyDropsService;
	@Autowired
	private WyCountService wyCountService;
	
	Log error = LogFactory.getLog("error");
	
	@ResponseBody
	@RequestMapping(value="getDropsById.htm",method=RequestMethod.POST)
	public AjaxResponse getDropsById(Integer id){
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			WyDrops wyDrops = wyDropsService.getDropsById(id);
			if(wyDrops != null){
				ajaxResponse.setCode(new Integer(0));
				ajaxResponse.setMsg("ok");
				ajaxResponse.setContent(wyDrops);
				int result = wyDropsService.addReadNumById(id);
				if(result != 1){
					error.error("[DropsController.getDropsById]增加id为：" + id + "的文章阅读数量失败");
				}
				result = wyCountService.upWyCountNum();
				if(result != 1){
					error.error("[DropsController.getDropsById]增加当天知识库阅读量失败");
				}
			}else{
				ajaxResponse.setCode(new Integer(401));
				ajaxResponse.setMsg("未找到id为" + id + "的文章");
			}
		} catch (Exception e) {
			error.error("[DropsController.getDropsById]" + e.getMessage(), e);
			ajaxResponse.setCode(new Integer(108));
			ajaxResponse.setMsg("操作失败");
		}
		
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="getAllDrops.htm",method=RequestMethod.POST)
	public AjaxResponse getAllDrops(Integer pageNum,Integer pageSize){
		AjaxResponse ajaxResponse = new AjaxResponse();
		if((pageNum < 1) || (pageSize < 1)){
			ajaxResponse.setCode(new Integer(402));
			ajaxResponse.setMsg("页数或每页条数不合法");
			return ajaxResponse;
		}
		try {
			List<WyDrops> wyDropsList = wyDropsService.getAllDrops(pageNum, pageSize);
			if((wyDropsList == null) || (wyDropsList.isEmpty())){
				ajaxResponse.setCode(new Integer(403));
				ajaxResponse.setMsg("结果为空");
				return ajaxResponse;
			}
			Iterator<WyDrops> iterator = wyDropsList.iterator();
			List<WyDropsResponse> responseList = new ArrayList<WyDropsResponse>();
			WyDropsResponse wyDropsResponse = null;
			while (iterator.hasNext()) {
				WyDrops drops = (WyDrops)iterator.next();
				if(drops.getStatus() == 1){					
					wyDropsResponse = new WyDropsResponse(drops);
					responseList.add(wyDropsResponse);
				}
			}
			ajaxResponse.setCode(new Integer(0));
			ajaxResponse.setMsg("ok");
			ajaxResponse.setContent(responseList);
		} catch (Exception e) {
			error.error("[DropsController.getAllDrops]" + e.getMessage(), e);
			ajaxResponse.setCode(new Integer(108));
			ajaxResponse.setMsg("操作失败");
		}
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="searchDrops.htm",method=RequestMethod.POST)
	public AjaxResponse searchDrops(String title,String author,Integer pageNum,Integer pageSize){
		AjaxResponse ajaxResponse = new AjaxResponse();
		WyDrops drops = new WyDrops();
		if(title != ""){
			drops.setTitle(title);
		}
		if(author != ""){
			drops.setAuthor(author);
		}
		try {
			List<WyDrops> dropsList = wyDropsService.searchDrops(drops, pageNum, pageSize);
			if((dropsList.isEmpty()) || (dropsList == null)){
				ajaxResponse.setCode(new Integer(403));
				ajaxResponse.setMsg("结果为空");
				return ajaxResponse;
			}
			List<WyDropsResponse> dropsResponses = new ArrayList<WyDropsResponse>();
			Iterator<WyDrops> wyDropsIterator = dropsList.iterator();
			WyDrops wyDrops;
			while(wyDropsIterator.hasNext()){
				wyDrops = (WyDrops)wyDropsIterator.next();
				WyDropsResponse response = new WyDropsResponse(wyDrops);
				dropsResponses.add(response);
			}
			ajaxResponse.setCode(new Integer(0));
			ajaxResponse.setMsg("ok");
			ajaxResponse.setContent(dropsResponses);
		} catch (Exception e) {
			error.error("[DropsController.searchDrops]" + e.getMessage(), e);
			ajaxResponse.setCode(new Integer(108));
			ajaxResponse.setMsg("操作失败");
		}
		return ajaxResponse;
	}
	
}
