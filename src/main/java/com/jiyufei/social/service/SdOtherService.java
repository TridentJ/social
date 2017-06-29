package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.SdOther;

/*
 *Created by jiyufei on 2016年10月26日 下午2:10:31 .
 */
public interface SdOtherService {

	public List<SdOther> getAllRecord() throws Exception;
	
	public SdOther getRecordByMail(String mail) throws Exception;
}
