package com.jiyufei.social.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jiyufei.social.bean.LoginUser;
import com.jiyufei.social.service.LoginUserService;



/*
 *Created by jiyufei on 2016年8月18日 上午11:00:02 .
 */
public class myUserDetailsService implements UserDetailsService {

	
	Log errorLog = LogFactory.getLog("error");
	
	@Autowired
	private LoginUserService loginUserService;
	
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		//LoginUser loginuser1 = new LoginUser();
		//loginuser1.setMail(arg0);
		try {
			LoginUser loginUser = loginUserService.getUserByMail(arg0);
			if(loginUser == null){
				errorLog.error("myUserDetailsService loginUser为null,email = " + arg0);
				throw new UsernameNotFoundException("用户名或密码错误");
			}
			if(loginUser.getStatus() == 0){
				throw new UsernameNotFoundException("帐号已被冻结");
			}
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			if(loginUser.getAuth() == 2){
				authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}else if(loginUser.getAuth() == 1){
				authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			}else{
				authList.add(new SimpleGrantedAuthority("ROLE_ANY"));
			}
			UserDetails userDetails = new User(loginUser.getMail(), loginUser.getPassword(), true, true, true, true, authList);
			return userDetails;
		} catch (Exception e) {
			errorLog.error("myUserDetailsService异常，用户名为：" + arg0 + "," + e.getMessage());
			throw new UsernameNotFoundException("系统异常");
		}
	}

}
