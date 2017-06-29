package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.SdZhenai;

/*
 *Created by jiyufei on 2016年10月26日 下午2:12:00 .
 */
public interface SdZhenaiService {

	public List<SdZhenai> getAllRecord() throws Exception;
	
	public SdZhenai getRecordByMail(String mail) throws Exception;
	
}
