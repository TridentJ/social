package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.WyCount;

/*
 *Created by jiyufei on 2016年11月1日 下午4:56:23 .
 */
public interface WyCountService {

	public List<WyCount> getWyCount() throws Exception;
	
	public Integer upWyCountNum() throws Exception;
	
}
