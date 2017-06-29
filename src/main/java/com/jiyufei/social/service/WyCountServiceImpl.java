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
import com.jiyufei.social.bean.WyCount;
import com.jiyufei.social.bean.WyCountExample;
import com.jiyufei.social.dao.WyCountMapper;

/*
 *Created by jiyufei on 2016年11月1日 下午4:59:06 .
 */
@Service("wyCountService")
public class WyCountServiceImpl implements WyCountService {

	@Autowired
	private WyCountMapper wyCountMapper;
	
	Log error = LogFactory.getLog("error");
	
	@Override
	public List<WyCount> getWyCount() throws Exception {
		WyCountExample example = new WyCountExample();
		example.createCriteria().andIdGreaterThan(new Integer(0));
		example.setOrderByClause("date desc");
		PageHelper.startPage(1, 10);
		List<WyCount> wyCounts = wyCountMapper.selectByExample(example);
		return wyCounts;
	}

	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Integer upWyCountNum() throws Exception {
		Date now = new Date();
		WyCountExample example = new WyCountExample();
		example.createCriteria().andDateEqualTo(now);
		List<WyCount> wyCounts = wyCountMapper.selectByExample(example);
		if(wyCounts == null){
			error.error("[WyCountService.upWyCountNum]添加记录失败");
		}else if(wyCounts.isEmpty()){
			WyCount wyCount = new WyCount();
			wyCount.setDate(now);
			wyCount.setNum(1);
			int result = wyCountMapper.insertSelective(wyCount);
			if(result == 0){
				error.error("[WyCountService.upWyCountNum]创建当天记录失败");
				return 2;
			}
		}else{
			WyCount count = wyCounts.get(0);
			if(count != null){
				int newNum = count.getNum() + 1;
				WyCount wyCount = new WyCount();
				wyCount.setNum(newNum);
				wyCount.setId(count.getId());
				int result = wyCountMapper.updateByPrimaryKeySelective(wyCount);
				if(result == 0){
					error.error("[WyCountService.upWyCountNum]添加记录失败");
					return 3;
				}
			}else{
				throw new RuntimeException("获取第一个对象失败");
			}
		}
		return 1;
	}

}
