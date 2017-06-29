package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.SdCsdn;

/*
 *Created by jiyufei on 2016年10月26日 下午2:09:08 .
 */
public interface SdCsdnService {

	public List<SdCsdn> getAllRecord() throws Exception;
	
	public SdCsdn getRecordByMail(String mail) throws Exception;
	
}
