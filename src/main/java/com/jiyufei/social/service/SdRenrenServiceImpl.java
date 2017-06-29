package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdRenren;
import com.jiyufei.social.bean.SdRenrenExample;
import com.jiyufei.social.dao.SdRenrenMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午5:07:01 .
 */
@Service("sdRenrenService")
public class SdRenrenServiceImpl implements SdRenrenService {

	@Autowired
	private SdRenrenMapper sdRenrenMapper;
	
	@Override
	public List<SdRenren> getAllRecord() throws Exception {
		SdRenrenExample example = new SdRenrenExample();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<SdRenren> list = sdRenrenMapper.selectByExample(example);
		return list;
	}

	@Override
	public SdRenren getRecordByMail(String mail) throws Exception {
		SdRenrenExample example = new SdRenrenExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdRenren> list = sdRenrenMapper.selectByExample(example);
		return list.get(0);
	}

}
