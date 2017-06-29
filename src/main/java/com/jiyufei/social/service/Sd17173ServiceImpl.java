package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.Sd17173;
import com.jiyufei.social.bean.Sd17173Example;
import com.jiyufei.social.dao.Sd17173Mapper;

/*
 *Created by jiyufei on 2016年10月26日 下午3:27:52 .
 */

@Service("sd17173Service")
public class Sd17173ServiceImpl implements Sd17173Service {

	@Autowired
	private Sd17173Mapper sd17173Mapper;
	
	@Override
	public List<Sd17173> getAllRecord() throws Exception {
		Sd17173Example example = new Sd17173Example();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<Sd17173> list = sd17173Mapper.selectByExample(example);
		return list;
	}

	@Override
	public Sd17173 getRecordByMail(String mail) throws Exception {
		Sd17173Example example = new Sd17173Example();
		example.createCriteria().andUserMailEqualTo(mail);
		List<Sd17173> list = sd17173Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
