package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.Sd163;

/*
 *Created by jiyufei on 2016年10月26日 下午2:08:28 .
 */
public interface Sd163Service {

	public List<Sd163> getAllRecord() throws Exception;
	
	public Sd163 getRecordByMail(String mail) throws Exception;
	
}
