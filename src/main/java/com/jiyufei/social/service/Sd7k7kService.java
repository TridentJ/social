package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.Sd7k7k;

/*
 *Created by jiyufei on 2016年10月26日 下午2:08:55 .
 */
public interface Sd7k7kService {

	public List<Sd7k7k> getAllRecord() throws Exception;
	
	public Sd7k7k getRecordByMail(String mail) throws Exception;
	
}
