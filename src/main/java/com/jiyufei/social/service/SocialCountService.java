package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.SocialCount;

/*
 *Created by jiyufei on 2016年11月1日 下午1:53:39 .
 */
public interface SocialCountService {
	
	public List<SocialCount> getSocialCount() throws Exception;
	
	public Integer upSocialCountNum() throws Exception;
}
