package com.jiyufei.social.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdIndexChar1;
import com.jiyufei.social.bean.SdIndexChar1Example;
import com.jiyufei.social.dao.SdIndexChar1Mapper;

/*
 *Created by jiyufei on 2016年10月26日 下午4:36:26 .
 */
@Service("sdIndexChar1")
public class SdIndexChar1ServiceImpl implements SdIndexChar1Service {

	@Autowired
	private SdIndexChar1Mapper sdIndexChar1Mapper;
	
	@Override
	public SdIndexChar1 getRecordByMail(String mail) throws Exception {
		SdIndexChar1Example example = new SdIndexChar1Example();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdIndexChar1> list = sdIndexChar1Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
