package com.jiyufei.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 *Created by jiyufei on 2016年11月1日 下午8:44:59 .
 */


import com.jiyufei.social.bean.Sd12306;
import com.jiyufei.social.bean.Sd163;
import com.jiyufei.social.bean.Sd17173;
import com.jiyufei.social.bean.Sd7k7k;
import com.jiyufei.social.bean.SdCsdn;
import com.jiyufei.social.bean.SdIndexChar1;
import com.jiyufei.social.bean.SdIndexChar2;
import com.jiyufei.social.bean.SdIndexChar4;
import com.jiyufei.social.bean.SdIndexNum;
import com.jiyufei.social.bean.SdOther;
import com.jiyufei.social.bean.SdRenren;
import com.jiyufei.social.bean.SdWeibo;
import com.jiyufei.social.bean.SdZhenai;
import com.jiyufei.social.bean.SocialHistory;
import com.jiyufei.social.service.Sd12306Service;
import com.jiyufei.social.service.Sd163Service;
import com.jiyufei.social.service.Sd17173Service;
import com.jiyufei.social.service.Sd7k7kService;
import com.jiyufei.social.service.SdCsdnService;
import com.jiyufei.social.service.SdIndexChar1Service;
import com.jiyufei.social.service.SdIndexChar2Service;
import com.jiyufei.social.service.SdIndexChar4Service;
import com.jiyufei.social.service.SdIndexNumService;
import com.jiyufei.social.service.SdOtherService;
import com.jiyufei.social.service.SdRenrenService;
import com.jiyufei.social.service.SdWeiboService;
import com.jiyufei.social.service.SdZhenaiService;
import com.jiyufei.social.service.SocialCountService;
import com.jiyufei.social.service.SocialHistoryService;
import com.jiyufei.social.service.SocialRecordService;
import com.jiyufei.social.util.AjaxSocial;
import com.jiyufei.social.util.SocialResultFour;
import com.jiyufei.social.util.SocialResultSeven;
import com.jiyufei.social.util.SocialResultThree;

@Controller
public class SocialController {

	@Autowired
	private SdIndexChar1Service sdIndexChar1Service;
	@Autowired
	private SdIndexChar2Service sdIndexChar2Service;
	@Autowired
	private SdIndexChar4Service sdIndexChar4Service;
	@Autowired
	private SdIndexNumService sdIndexNumService;
	@Autowired
	private Sd12306Service sd12306Service;
	@Autowired
	private Sd163Service sd163Service;
	@Autowired
	private Sd17173Service sd17173Service;
	@Autowired
	private Sd7k7kService sd7k7kService;
	@Autowired
	private SdCsdnService sdCsdnService;
	@Autowired
	private SdOtherService sdOtherService;
	@Autowired
	private SdRenrenService sdRenrenService;
	@Autowired
	private SdWeiboService sdWeiboService;
	@Autowired
	private SdZhenaiService sdZhenaiService;
	@Autowired
	private SocialRecordService socialRecordService;
	@Autowired
	private SocialHistoryService socialHistoryService;
	@Autowired
	private SocialCountService socialCountService;
	
	
	Log error = LogFactory.getLog("error");
	
	
	
	private SocialResultThree getOneRecordThree(String db,String mail){
		SocialResultThree srt = null;
		try {
			if(db.compareTo("sd_163") == 0){
				Sd163 sd = sd163Service.getRecordByMail(mail);
				srt = new SocialResultThree(sd);
			}else if(db.compareTo("sd_7k7k") == 0){
				Sd7k7k sd = sd7k7kService.getRecordByMail(mail);
				srt = new SocialResultThree(sd);
			}else if(db.compareTo("sd_other") == 0){
				SdOther sd = sdOtherService.getRecordByMail(mail);
				srt = new SocialResultThree(sd);
			}else if(db.compareTo("sd_renren") == 0){
				SdRenren sd = sdRenrenService.getRecordByMail(mail);
				srt = new SocialResultThree(sd);
			}else if(db.compareTo("sd_weibo") == 0){
				SdWeibo sd = sdWeiboService.getRecordByMail(mail);
				srt = new SocialResultThree(sd);
			}
		} catch (Exception e) {
			error.error("[SocialController.getOneRecordThree] db = " + db + ",mail = " + mail,e);
			return null;
		}
		return srt;
	}
	
	private SocialResultFour getOneRecordFour(String db,String mail){
		SocialResultFour srf = null;
		try {
			if(db.compareTo("sd_17173") == 0){
				Sd17173 sd = sd17173Service.getRecordByMail(mail);
				srf = new SocialResultFour(sd);
			}else if(db.compareTo("sd_zhenai") == 0){
				SdZhenai sd = sdZhenaiService.getRecordByMail(mail);
				srf = new SocialResultFour(sd);
			}else if(db.compareTo("sd_csdn") == 0){
				SdCsdn sd = sdCsdnService.getRecordByMail(mail);
				srf = new SocialResultFour(sd);
			}else{
				srf = new SocialResultFour(getOneRecordThree(db, mail));
			}
		} catch (Exception e) {
			error.error("[SocialController.getOneRecordFour] db = " + db + ",mail = " + mail,e);
			return null;
		}
		return srf;
	}
	
	private SocialResultSeven getOneRecordSeven(String db,String mail){
		SocialResultSeven srs = null;
		try {
			if(db.compareTo("sd_12306") == 0){
				Sd12306 sd = sd12306Service.getRecordByMail(mail);
				srs = new SocialResultSeven(sd);
			}else{
				srs = new SocialResultSeven(getOneRecordFour(db, mail));
			}
		} catch (Exception e) {
			error.error("[SocialController.getOneRecordSeven] db = " + db + ",mail = " + mail,e);
			return null;
		}
		return srs;
	}
	
	//获取所有记录
	private AjaxSocial getAllRecordByMail(String flag,String mail){
		AjaxSocial ajaxSocial = new AjaxSocial();
		int maxColumn = 3;
		if(flag.indexOf("sd_12306") >= 0){
			maxColumn = 7;
		}else if((flag.indexOf("sd_17173") >= 0)||(flag.indexOf("sd_csdn") >= 0)||(flag.indexOf("sd_zhenai") >= 0)){
			maxColumn = 4;
		}
		if(flag.indexOf("|") >= 0){						
			String[] flagArray = flag.split("\\|");
			if(maxColumn == 3){
				List<SocialResultThree> srtList = new ArrayList<SocialResultThree>();
				for(int i=0;i<flagArray.length;i++){
					SocialResultThree srt = getOneRecordThree(flagArray[i], mail);
					srtList.add(srt);
				}
				ajaxSocial.setContent(srtList);
			}else if(maxColumn == 4){
				List<SocialResultFour> srfList = new ArrayList<SocialResultFour>();
				for(int i=0;i<flagArray.length;i++){
					SocialResultFour srf = getOneRecordFour(flagArray[i], mail);
					srfList.add(srf);
				}
				ajaxSocial.setContent(srfList);
			}else if(maxColumn == 7){
				List<SocialResultSeven> srsList = new ArrayList<SocialResultSeven>();
				for(int i=0;i<flagArray.length;i++){
					SocialResultSeven srs = getOneRecordSeven(flagArray[i], mail);
					srsList.add(srs);
				}
				ajaxSocial.setContent(srsList);
			}
			
		}else{
			if(maxColumn == 3){
				SocialResultThree srt = getOneRecordThree(flag, mail);
				ajaxSocial.setContent(srt);
			}else if(maxColumn == 4){
				SocialResultFour srf = getOneRecordFour(flag, mail);
				ajaxSocial.setContent(srf);
			}else if(maxColumn == 7){
				SocialResultSeven srs = getOneRecordSeven(flag, mail);
				ajaxSocial.setContent(srs);
			}
		}
		ajaxSocial.setCode(new Integer(0));
		ajaxSocial.setMsg("ok");
		ajaxSocial.setColumn(maxColumn+1);
		return ajaxSocial;
	}
	
	/*
	 * fuzzy:模糊查询
	 * 0：关闭
	 * 1：开启
	 * */
	@ResponseBody
	@RequestMapping(value="searchByMail.htm",method=RequestMethod.POST)
	public AjaxSocial searchByMail(String search,Integer fuzzy){
		AjaxSocial ajaxSocial = new AjaxSocial();
		try {
			if(fuzzy == 1){
				//模糊查询
				ajaxSocial.setCode(new Integer(150));
				ajaxSocial.setMsg("功能未实现,敬请期待");
				return ajaxSocial;
			}else{
				//精确查询
				char firstLetters = search.charAt(0);
				if((firstLetters >= 'a') && (firstLetters <= 'm')){
					SdIndexChar1 sdIndexChar1 = sdIndexChar1Service.getRecordByMail(search);
					if(sdIndexChar1 == null){
						ajaxSocial.setCode(new Integer(100));
						ajaxSocial.setMsg("结果为空");
					}else{
						String flag = sdIndexChar1.getUserFlag();
						//String mail = sdIndexChar1.getUserMail();
						ajaxSocial = getAllRecordByMail(flag, search);
					}
				}else if((firstLetters >= 'n') && (firstLetters <= 'z')){
					SdIndexChar2 sdIndexChar2 = sdIndexChar2Service.getRecordByMail(search);
					if(sdIndexChar2 == null){
						ajaxSocial.setCode(new Integer(100));
						ajaxSocial.setMsg("结果为空");
					}else{
						String flag = sdIndexChar2.getUserFlag();
						//String mail = sdIndexChar2.getUserMail();
						ajaxSocial = getAllRecordByMail(flag, search);
					}
				}else if((firstLetters >= '0') && (firstLetters <= '9')){
					SdIndexNum sdIndexNum = sdIndexNumService.getRecordByMail(search);
					if(sdIndexNum == null){
						ajaxSocial.setCode(new Integer(100));
						ajaxSocial.setMsg("结果为空");
					}else{
						String flag = sdIndexNum.getUserFlag();
						//String mail = sdIndexNum.getUserMail();
						ajaxSocial = getAllRecordByMail(flag, search);
					}
				}else if((firstLetters >= '!') && (firstLetters <= '`')){
					SdIndexChar4 sdIndexChar4 = sdIndexChar4Service.getRecordByMail(search);
					if(sdIndexChar4 == null){
						ajaxSocial.setCode(new Integer(100));
						ajaxSocial.setMsg("结果为空");
					}else{
						String flag = sdIndexChar4.getUserFlag();
						//String mail = sdIndexChar4.getUserMail();
						ajaxSocial = getAllRecordByMail(flag, search);
					}
				}else{
					ajaxSocial.setCode(new Integer(301));
					ajaxSocial.setMsg("邮箱不合法");
				}
			}
			
		} catch (Exception e) {
			error.error("[SocialController.searchByMail] mail = " + search, e);
			ajaxSocial.setCode(new Integer(108));
			ajaxSocial.setMsg("操作失败");
		}
		/*
		 * 添加查询记录
		 * 
		 * */
		try {
			SocialHistory socialHistory = new SocialHistory();
			socialHistory.setContent(search);
			socialHistory.setType(1);
			if(ajaxSocial.getCode() == 100){
				socialRecordService.upSocialRecordNum(0);
				socialHistory.setHit(0);
				socialHistoryService.addHistory(socialHistory);
			}else if(ajaxSocial.getCode() == 0){
				socialRecordService.upSocialRecordNum(1);
				socialHistory.setHit(1);
				socialHistoryService.addHistory(socialHistory);
			}
			socialCountService.upSocialCountNum();
		} catch (Exception e) {
			error.error("[SocialController.searchByMail] mail = " + search + ",添加social_record失败", e);
		}
		return ajaxSocial;
	}
	
	
	private AjaxSocial getAllRecordByAll(String flag,String mail){
		AjaxSocial ajaxSocial = new AjaxSocial();
		int maxColumn = 7;
		if(flag.indexOf("|") >= 0){						
			String[] flagArray = flag.split("\\|");
			List<SocialResultSeven> srsList = new ArrayList<SocialResultSeven>();
			for(int i=0;i<flagArray.length;i++){
				SocialResultSeven srs = getOneRecordSeven(flagArray[i], mail);
				srsList.add(srs);
			}
			ajaxSocial.setContent(srsList);
		}else{
			SocialResultSeven srs = getOneRecordSeven(flag, mail);
			ajaxSocial.setContent(srs);
		}
		ajaxSocial.setCode(new Integer(0));
		ajaxSocial.setMsg("ok");
		ajaxSocial.setColumn(maxColumn+1);
		return ajaxSocial;
	}
	
	
	//通过邮箱的通用查询
	private AjaxSocial generalSearchMail(String mail){
		AjaxSocial ajaxSocial = new AjaxSocial();
		try {
			char firstLetters = mail.charAt(0);
			if((firstLetters >= 'a') && (firstLetters <= 'm')){
				SdIndexChar1 sdIndexChar1 = sdIndexChar1Service.getRecordByMail(mail);
				if(sdIndexChar1 == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String flag = sdIndexChar1.getUserFlag();
					ajaxSocial = getAllRecordByAll(flag, mail);
				}
			}else if((firstLetters >= 'n') && (firstLetters <= 'z')){
				SdIndexChar2 sdIndexChar2 = sdIndexChar2Service.getRecordByMail(mail);
				if(sdIndexChar2 == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String flag = sdIndexChar2.getUserFlag();
					ajaxSocial = getAllRecordByAll(flag, mail);
				}
			}else if((firstLetters >= '0') && (firstLetters <= '9')){
				SdIndexNum sdIndexNum = sdIndexNumService.getRecordByMail(mail);
				if(sdIndexNum == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String flag = sdIndexNum.getUserFlag();
					ajaxSocial = getAllRecordByAll(flag, mail);
				}
			}else if((firstLetters >= '!') && (firstLetters <= '`')){
				SdIndexChar4 sdIndexChar4 = sdIndexChar4Service.getRecordByMail(mail);
				if(sdIndexChar4 == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String flag = sdIndexChar4.getUserFlag();
					ajaxSocial = getAllRecordByAll(flag, mail);
				}
			}else{
				ajaxSocial.setCode(new Integer(301));
				ajaxSocial.setMsg("邮箱不合法");
			}
		} catch (Exception e) {
			error.error("[SocialController.generalSearchMail] mail = " + mail, e);
			ajaxSocial.setCode(new Integer(108));
			ajaxSocial.setMsg("操作失败");
		}
		return ajaxSocial;
	}
	
	
	@ResponseBody
	@RequestMapping(value="searchById.htm",method=RequestMethod.POST)
	public AjaxSocial searchById(String search,Integer fuzzy){
		AjaxSocial ajaxSocial = new AjaxSocial();
		try {
			if(fuzzy == 1){
				//模糊查询
				ajaxSocial.setCode(new Integer(150));
				ajaxSocial.setMsg("功能未实现,敬请期待");
				return ajaxSocial;
			}else{
				Sd12306 sd12306 = sd12306Service.getRecordByCard(search);
				if(sd12306 == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String mail = sd12306.getUserMail();
					ajaxSocial = generalSearchMail(mail);
				}
			}
		} catch (Exception e) {
			error.error("[SocialController.searchById]", e);
			ajaxSocial.setCode(new Integer(108));
			ajaxSocial.setMsg("操作失败");
		}
		/*
		 * 添加查询记录
		 * 
		 * */
		try {
			SocialHistory socialHistory = new SocialHistory();
			socialHistory.setContent(search);
			socialHistory.setType(3);
			if(ajaxSocial.getCode() == 100){
				socialRecordService.upSocialRecordNum(0);
				socialHistory.setHit(0);
				socialHistoryService.addHistory(socialHistory);
			}else if(ajaxSocial.getCode() == 0){
				socialRecordService.upSocialRecordNum(1);
				socialHistory.setHit(1);
				socialHistoryService.addHistory(socialHistory);
			}
			socialCountService.upSocialCountNum();
		} catch (Exception e) {
			error.error("[SocialController.searchById] id = " + search + ",添加social_record失败", e);
		}
		return ajaxSocial;
	}
	
	
	@ResponseBody
	@RequestMapping(value="searchByName.htm",method=RequestMethod.POST)
	public AjaxSocial searchByName(String search,Integer fuzzy){
		AjaxSocial ajaxSocial = new AjaxSocial();
		try {
			if(fuzzy == 1){
				//模糊查询
				ajaxSocial.setCode(new Integer(150));
				ajaxSocial.setMsg("功能未实现,敬请期待");
				return ajaxSocial;
			}else{
				Sd12306 sd12306 = sd12306Service.getRecordByName(search);
				if(sd12306 == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String mail = sd12306.getUserMail();
					ajaxSocial = generalSearchMail(mail);
				}
			}
		} catch (Exception e) {
			error.error("[SocialController.searchById]", e);
			ajaxSocial.setCode(new Integer(108));
			ajaxSocial.setMsg("操作失败");
		}
		/*
		 * 添加查询记录
		 * 
		 * */
		try {
			SocialHistory socialHistory = new SocialHistory();
			socialHistory.setContent(search);
			socialHistory.setType(4);
			if(ajaxSocial.getCode() == 100){
				socialRecordService.upSocialRecordNum(0);
				socialHistory.setHit(0);
				socialHistoryService.addHistory(socialHistory);
			}else if(ajaxSocial.getCode() == 0){
				socialRecordService.upSocialRecordNum(1);
				socialHistory.setHit(1);
				socialHistoryService.addHistory(socialHistory);
			}
			socialCountService.upSocialCountNum();
		} catch (Exception e) {
			error.error("[SocialController.searchByName] Name = " + search + ",添加social_record失败", e);
		}
		return ajaxSocial;
	}
	
	@ResponseBody
	@RequestMapping(value="searchByPhone.htm",method=RequestMethod.POST)
	public AjaxSocial searchByPhone(String search,Integer fuzzy){
		AjaxSocial ajaxSocial = new AjaxSocial();
		try {
			if(fuzzy == 1){
				//模糊查询
				ajaxSocial.setCode(new Integer(150));
				ajaxSocial.setMsg("功能未实现,敬请期待");
				return ajaxSocial;
			}else{
				Sd12306 sd12306 = sd12306Service.getRecordByPhone(search);
				if(sd12306 == null){
					ajaxSocial.setCode(new Integer(100));
					ajaxSocial.setMsg("结果为空");
				}else{
					String mail = sd12306.getUserMail();
					ajaxSocial = generalSearchMail(mail);
				}
			}
		} catch (Exception e) {
			error.error("[SocialController.searchById]", e);
			ajaxSocial.setCode(new Integer(108));
			ajaxSocial.setMsg("操作失败");
		}
		/*
		 * 添加查询记录
		 * 
		 * */
		try {
			SocialHistory socialHistory = new SocialHistory();
			socialHistory.setContent(search);
			socialHistory.setType(2);
			if(ajaxSocial.getCode() == 100){
				socialRecordService.upSocialRecordNum(0);
				socialHistory.setHit(0);
				socialHistoryService.addHistory(socialHistory);
			}else if(ajaxSocial.getCode() == 0){
				socialRecordService.upSocialRecordNum(1);
				socialHistory.setHit(1);
				socialHistoryService.addHistory(socialHistory);
			}
			socialCountService.upSocialCountNum();
		} catch (Exception e) {
			error.error("[SocialController.searchByPhone] Phone = " + search + ",添加social_record失败", e);
		}
		return ajaxSocial;
	}
	
}
