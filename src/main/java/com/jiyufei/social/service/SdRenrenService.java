package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.SdRenren;
/*
 *Created by jiyufei on 2016年10月26日 下午2:11:30 .
 */
public interface SdRenrenService {

	public List<SdRenren> getAllRecord() throws Exception;
	
	public SdRenren getRecordByMail(String mail) throws Exception;
}
