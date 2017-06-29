package com.jiyufei.social.service;

import java.util.List;
/*
 *Created by jiyufei on 2016年10月26日 下午2:11:50 .
 */

import com.jiyufei.social.bean.SdWeibo;
public interface SdWeiboService {

	public List<SdWeibo> getAllRecord() throws Exception;
	
	public SdWeibo getRecordByMail(String mail)throws Exception;
	
}
