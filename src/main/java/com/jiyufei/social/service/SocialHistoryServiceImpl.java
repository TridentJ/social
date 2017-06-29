package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jiyufei.social.bean.SocialHistory;
import com.jiyufei.social.bean.SocialHistoryExample;
import com.jiyufei.social.dao.SocialHistoryMapper;

/*
 *Created by jiyufei on 2016年11月1日 下午12:20:42 .
 */
@Service("socialHistoryService")
public class SocialHistoryServiceImpl implements SocialHistoryService {

	@Autowired
	private SocialHistoryMapper socialHistoryMapper;
	
	@Override
	public List<SocialHistory> getHistory() throws Exception {
		SocialHistoryExample example = new SocialHistoryExample();
		example.createCriteria().andIdGreaterThan(new Integer(0));
		example.setOrderByClause("time desc");
		PageHelper.startPage(1, 10);
		List<SocialHistory> socialHistories = socialHistoryMapper.selectByExample(example);
		return socialHistories;
	}

	@Override
	public List<SocialHistory> getAllHistory(Integer pageNum,Integer pageSize) throws Exception {
		SocialHistoryExample example = new SocialHistoryExample();
		example.createCriteria().andIdGreaterThan(new Integer(0));
		PageHelper.startPage(pageNum, pageSize);
		List<SocialHistory> socialHistories = socialHistoryMapper.selectByExample(example);
		return socialHistories;
	}

	@Override
	public Integer addHistory(SocialHistory history) throws Exception {
		Integer result = socialHistoryMapper.insertSelective(history);
		return result;
	}

}
