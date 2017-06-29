package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.Sd163;
import com.jiyufei.social.bean.Sd163Example;
import com.jiyufei.social.dao.Sd163Mapper;

/*
 *Created by jiyufei on 2016年10月26日 下午2:33:40 .
 */
@Service("sd163Service")
public class Sd163ServiceImpl implements Sd163Service {

	@Autowired
	private Sd163Mapper sd163Mapper;
	
	@Override
	public List<Sd163> getAllRecord() throws Exception {
		Sd163Example example = new Sd163Example();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<Sd163> list = sd163Mapper.selectByExample(example);
		return list;
	}

	@Override
	public Sd163 getRecordByMail(String mail) throws Exception {
		Sd163Example example = new Sd163Example();
		example.createCriteria().andUserMailEqualTo(mail);
		List<Sd163> list = sd163Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
