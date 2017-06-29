package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdZhenai;
import com.jiyufei.social.bean.SdZhenaiExample;
import com.jiyufei.social.dao.SdZhenaiMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午5:14:49 .
 */
@Service("sdZhenaiService")
public class SdZhenaiServiceImpl implements SdZhenaiService {

	@Autowired
	private SdZhenaiMapper sdZhenaiMapper;
	
	@Override
	public List<SdZhenai> getAllRecord() throws Exception {
		SdZhenaiExample example = new SdZhenaiExample();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<SdZhenai> list = sdZhenaiMapper.selectByExample(example);
		return list;
	}

	@Override
	public SdZhenai getRecordByMail(String mail) throws Exception {
		SdZhenaiExample example = new SdZhenaiExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdZhenai> list = sdZhenaiMapper.selectByExample(example);
		return list.get(0);
	}

}
