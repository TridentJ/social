package com.jiyufei.social.util;

import com.jiyufei.social.bean.Sd12306;

/*
 *Created by jiyufei on 2016年11月1日 下午10:45:42 .
 */
public class SocialResultSeven {

	private Integer userId;
    private String userName;
    private String userMail;
    private String userPasswd;
    private String userCard;
    private String userPhone;
    private String userUndef;
    private String userForm;
    
    public SocialResultSeven(){
    	
    }
    
    public SocialResultSeven(Sd12306 sd){
    	this.userId = sd.getUserId();
    	this.userName = sd.getUserName();
    	this.userMail = sd.getUserMail();
    	this.userPasswd = sd.getUserPasswd();
    	this.userCard = sd.getUserCard();
    	this.userPhone = sd.getUserPhone();
    	this.userUndef = sd.getUserUndef();
    	this.userForm = "铁路售票网";
    }
    
    public SocialResultSeven(SocialResultFour sd){
    	this.userId = sd.getUserId();
    	this.userName = sd.getUserName();
    	this.userMail = sd.getUserMail();
    	this.userPasswd = sd.getUserPasswd();
    	this.userCard = "";
    	this.userPhone = "";
    	this.userUndef = "";
    	this.userForm = sd.getUserForm();
    }
    
    public SocialResultSeven(SocialResultThree sd){
    	this.userId = sd.getUserId();
    	this.userName = "";
    	this.userMail = sd.getUserMail();
    	this.userPasswd = sd.getUserPasswd();
    	this.userCard = "";
    	this.userPhone = "";
    	this.userUndef = "";
    	this.userForm = sd.getUserForm();
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

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserUndef() {
        return userUndef;
    }

    public void setUserUndef(String userUndef) {
        this.userUndef = userUndef;
    }

	public String getUserForm() {
		return userForm;
	}

	public void setUserForm(String userForm) {
		this.userForm = userForm;
	}
	
}
