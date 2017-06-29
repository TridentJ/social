package com.jiyufei.social.util;

import com.jiyufei.social.bean.Sd163;
import com.jiyufei.social.bean.Sd7k7k;
import com.jiyufei.social.bean.SdOther;
import com.jiyufei.social.bean.SdRenren;
import com.jiyufei.social.bean.SdWeibo;

/*
 *Created by jiyufei on 2016年11月1日 下午10:36:31 .
 */
public class SocialResultThree {
	
	private Integer userId;
	private String userMail;
	private String userPasswd;
	private String userForm;
	
	public SocialResultThree(){
		
	}
	
	public SocialResultThree(Sd163 sd){
		this.userId = sd.getUserId();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "网易";
	}
	
	public SocialResultThree(Sd7k7k sd){
		this.userId = sd.getUserId();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "7k7k";
	}
	
	public SocialResultThree(SdOther sd){
		this.userId = sd.getUserId();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "其他";
	}
	
	public SocialResultThree(SdRenren sd){
		this.userId = sd.getUserId();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "人人网";
	}
	
	public SocialResultThree(SdWeibo sd){
		this.userId = sd.getUserId();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "新浪微博";
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserForm() {
		return userForm;
	}

	public void setUserForm(String userForm) {
		this.userForm = userForm;
	}
	
	
}
