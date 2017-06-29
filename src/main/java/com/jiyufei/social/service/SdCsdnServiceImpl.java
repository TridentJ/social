package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdCsdn;
import com.jiyufei.social.bean.SdCsdnExample;
import com.jiyufei.social.dao.SdCsdnMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午4:03:04 .
 */
@Service("sdCsdnService")
public class SdCsdnServiceImpl implements SdCsdnService {

	@Autowired
	private SdCsdnMapper sdCsdnMapper;
	
	@Override
	public List<SdCsdn> getAllRecord() throws Exception {
		SdCsdnExample example = new SdCsdnExample();
		example.createCriteria().andUserIdGreaterThan(new Integer(0));
		List<SdCsdn> list = sdCsdnMapper.selectByExample(example);
		return list;
	}

	@Override
	public SdCsdn getRecordByMail(String mail) throws Exception {
		SdCsdnExample example = new SdCsdnExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdCsdn> list = sdCsdnMapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
