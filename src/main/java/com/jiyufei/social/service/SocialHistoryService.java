package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.SocialHistory;

/*
 *Created by jiyufei on 2016年11月1日 下午12:19:00 .
 */
public interface SocialHistoryService {

	public List<SocialHistory> getHistory() throws Exception;
	
	public List<SocialHistory> getAllHistory(Integer pageNum,Integer pageSize) throws Exception;
	
	public Integer addHistory(SocialHistory history) throws Exception;
}
