package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.Sd7k7k;
import com.jiyufei.social.bean.Sd7k7kExample;
import com.jiyufei.social.dao.Sd7k7kMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午3:36:12 .
 */
@Service("sd7k7kService")
public class Sd7k7kServiceImpl implements Sd7k7kService {

	@Autowired
	private Sd7k7kMapper sd7k7kMapper;
	
	@Override
	public List<Sd7k7k> getAllRecord() throws Exception {
		Sd7k7kExample example = new Sd7k7kExample();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<Sd7k7k> list = sd7k7kMapper.selectByExample(example);
		return list;
	}

	@Override
	public Sd7k7k getRecordByMail(String mail) throws Exception {
		Sd7k7kExample example = new Sd7k7kExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<Sd7k7k> list = sd7k7kMapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
