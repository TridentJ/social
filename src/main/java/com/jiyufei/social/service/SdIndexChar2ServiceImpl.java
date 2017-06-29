package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdIndexChar2;
import com.jiyufei.social.bean.SdIndexChar2Example;
import com.jiyufei.social.dao.SdIndexChar2Mapper;

/*
 *Created by jiyufei on 2016年10月26日 下午4:40:12 .
 */
@Service("sdIndexChar2")
public class SdIndexChar2ServiceImpl implements SdIndexChar2Service {

	@Autowired
	private SdIndexChar2Mapper sdIndexChar2Mapper;
	
	@Override
	public SdIndexChar2 getRecordByMail(String mail) throws Exception {
		SdIndexChar2Example example = new SdIndexChar2Example();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdIndexChar2> list = sdIndexChar2Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
