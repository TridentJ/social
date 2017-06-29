package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.Sd12306;

/*
 *Created by jiyufei on 2016年10月26日 下午2:08:14 .
 */
public interface Sd12306Service {

	public List<Sd12306> getAllRecord() throws Exception;
	
	public Sd12306 getRecordByMail(String mail) throws Exception;

	public Sd12306 getRecordByName(String name) throws Exception;
	
	public Sd12306 getRecordByCard(String card) throws Exception;
	
	public Sd12306 getRecordByPhone(String phone) throws Exception;
	
}
