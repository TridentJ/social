package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdWeibo;
import com.jiyufei.social.bean.SdWeiboExample;
import com.jiyufei.social.dao.SdWeiboMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午5:10:38 .
 */
@Service("sdWeiboService")
public class SdWeiboServiceImpl implements SdWeiboService {

	@Autowired
	private SdWeiboMapper sdWeiboMapper;
	
	@Override
	public List<SdWeibo> getAllRecord() throws Exception {
		SdWeiboExample example = new SdWeiboExample();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<SdWeibo> list = sdWeiboMapper.selectByExample(example);
		return list;
	}

	@Override
	public SdWeibo getRecordByMail(String mail) throws Exception {
		SdWeiboExample example = new SdWeiboExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdWeibo> list = sdWeiboMapper.selectByExample(example);
		return list.get(0);
	}

}
