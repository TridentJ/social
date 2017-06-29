package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdIndexNum;
import com.jiyufei.social.bean.SdIndexNumExample;
import com.jiyufei.social.dao.SdIndexNumMapper;

/*
 *Created by jiyufei on 2016年10月26日 下午4:55:16 .
 */
@Service("sdIndexNumService")
public class SdIndexNumServiceImpl implements SdIndexNumService {

	@Autowired
	private SdIndexNumMapper SdIndexNumMapper;
	
	@Override
	public SdIndexNum getRecordByMail(String mail) throws Exception {
		SdIndexNumExample example = new SdIndexNumExample();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdIndexNum> list = SdIndexNumMapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
