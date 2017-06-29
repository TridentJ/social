package com.jiyufei.social.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.jiyufei.social.bean.SocialCount;
import com.jiyufei.social.bean.SocialCountExample;
import com.jiyufei.social.dao.SocialCountMapper;

/*
 *Created by jiyufei on 2016年11月1日 下午1:57:02 .
 */
@Service("socialCountService")
public class SocialCountServiceImpl implements SocialCountService {

	@Autowired
	private SocialCountMapper socialCountMapper;
	
	Log info = LogFactory.getLog("info");
	Log error = LogFactory.getLog("error");
	
	@Override
	public List<SocialCount> getSocialCount() throws Exception {
		SocialCountExample example = new SocialCountExample();
		example.createCriteria().andIdGreaterThan(new Integer(0));
		example.setOrderByClause("date desc");
		PageHelper.startPage(1, 10);
		List<SocialCount> socialCounts = socialCountMapper.selectByExample(example);
		return socialCounts;
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Integer upSocialCountNum() throws Exception {
		Date now = new Date();
		SocialCountExample example = new SocialCountExample();
		example.createCriteria().andDateEqualTo(now);
		List<SocialCount> socialCounts = socialCountMapper.selectByExample(example);
		if(socialCounts == null){
			error.error("[SocialCountService.upSocialCountNum]socialCounts 为 null");
			return 0;
		}
		if(socialCounts.isEmpty()){
			SocialCount socialCount = new SocialCount();
			socialCount.setNum(1);
			socialCount.setDate(now);
			int result = socialCountMapper.insertSelective(socialCount);
			if(result == 0){
				error.error("[SocialCountService.upSocialCountNum]创建当天记录失败");
				return 2;
			}
		}else{
			if(socialCounts.get(0) != null){
				SocialCount count = socialCounts.get(0);
				int newNum = count.getNum() + 1;
				SocialCount socialCount = new SocialCount();
				socialCount.setId(count.getId());
				socialCount.setNum(newNum);
				int result = socialCountMapper.updateByPrimaryKeySelective(socialCount);
				if(result == 0){
					error.error("[SocialCountService.upSocialCountNum]添加记录失败");
					return 3;
				}
			}else{
				throw new RuntimeException("获取第一个对象失败");
			}
		}
		return 1;
	}

}
