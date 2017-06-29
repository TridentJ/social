package com.jiyufei.social.service;

import com.jiyufei.social.bean.LoginUser;

/*
 *Created by jiyufei on 2016年10月27日 上午10:14:02 .
 */
public interface LoginUserService {

public LoginUser getUserById(Integer id) throws Exception;
	
	public LoginUser getUserByMail(String mail) throws Exception;
	
	public int addUser(LoginUser user) throws Exception;
	
	public int frozeUserById(Integer id) throws Exception;
	
	public int updateUserById(LoginUser user) throws Exception;
	
}
