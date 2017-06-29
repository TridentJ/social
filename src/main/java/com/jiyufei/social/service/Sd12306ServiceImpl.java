package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.Sd12306;
import com.jiyufei.social.bean.Sd12306Example;
import com.jiyufei.social.dao.Sd12306Mapper;

/*
 *Created by jiyufei on 2016年10月26日 下午2:18:33 .
 */
@Service("sd12306Service")
public class Sd12306ServiceImpl implements Sd12306Service {

	@Autowired
	private Sd12306Mapper sd12306Mapper;
	
	@Override
	public List<Sd12306> getAllRecord() throws Exception {
		Sd12306Example example = new Sd12306Example();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<Sd12306> list = sd12306Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	@Override
	public Sd12306 getRecordByMail(String mail) throws Exception {
		Sd12306Example example = new Sd12306Example();
		example.createCriteria().andUserMailEqualTo(mail);
		List<Sd12306> list = sd12306Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	@Override
	public Sd12306 getRecordByName(String name) throws Exception {
		Sd12306Example example = new Sd12306Example();
		example.createCriteria().andUserNameEqualTo(name);
		List<Sd12306> list = sd12306Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	@Override
	public Sd12306 getRecordByCard(String card) throws Exception {
		Sd12306Example example = new Sd12306Example();
		example.createCriteria().andUserCardEqualTo(card);
		List<Sd12306> list = sd12306Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	@Override
	public Sd12306 getRecordByPhone(String phone) throws Exception {
		Sd12306Example example = new Sd12306Example();
		example.createCriteria().andUserPhoneEqualTo(phone);
		List<Sd12306> list = sd12306Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
