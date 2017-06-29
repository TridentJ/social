package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.Sd17173;

/*
 *Created by jiyufei on 2016年10月26日 下午2:08:43 .
 */
public interface Sd17173Service {

	public List<Sd17173> getAllRecord() throws Exception;
	
	public Sd17173 getRecordByMail(String mail) throws Exception;
	
}
