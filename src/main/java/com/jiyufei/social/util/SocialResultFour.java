package com.jiyufei.social.util;

import com.jiyufei.social.bean.Sd17173;
import com.jiyufei.social.bean.SdCsdn;
import com.jiyufei.social.bean.SdZhenai;

/*
 *Created by jiyufei on 2016年11月1日 下午10:42:25 .
 */
public class SocialResultFour {

	private Integer userId;
	private String userName;
	private String userMail;
	private String userPasswd;
	private String userForm;
	
	public SocialResultFour(){
		
	}
	
	public SocialResultFour(Sd17173 sd){
		this.userId = sd.getUserId();
		this.userName = sd.getUserName();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "17173";
	}
	
	public SocialResultFour(SdCsdn sd){
		this.userId = sd.getUserId();
		this.userName = sd.getUserName();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "csdn";
	}
	
	public SocialResultFour(SdZhenai sd){
		this.userId = sd.getUserId();
		this.userName = sd.getUserName();
		this.userMail = sd.getUserMail();
		this.userPasswd = sd.getUserPasswd();
		this.userForm = "珍爱网";
	}
	
	public SocialResultFour(SocialResultThree srt){
		this.userId = srt.getUserId();
		this.userMail = srt.getUserMail();
		this.userPasswd = srt.getUserPasswd();
		this.userName = "";
		this.userForm = srt.getUserForm();
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
