package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdOther;
import com.jiyufei.social.bean.SdOtherExample;
import com.jiyufei.social.dao.SdOtherMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午5:01:11 .
 */
@Service("sdOtherService")
public class SdOtherServiceImpl implements SdOtherService {

	@Autowired
	private SdOtherMapper sdOtherMapper;
	
	@Override
	public List<SdOther> getAllRecord() throws Exception {
		SdOtherExample example = new SdOtherExample();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<SdOther> list = sdOtherMapper.selectByExample(example);
		return list;
	}

	@Override
	public SdOther getRecordByMail(String mail) throws Exception {
		SdOtherExample example = new SdOtherExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdOther> list = sdOtherMapper.selectByExample(example);
		return list.get(0);
	}

}
