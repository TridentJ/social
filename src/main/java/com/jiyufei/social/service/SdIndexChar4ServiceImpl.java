package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.SdIndexChar4;
import com.jiyufei.social.bean.SdIndexChar4Example;
import com.jiyufei.social.dao.SdIndexChar4Mapper;

/*
 *Created by jiyufei on 2016年10月26日 下午4:40:12 .
 */
@Service("sdIndexChar4")
public class SdIndexChar4ServiceImpl implements SdIndexChar4Service {

	@Autowired
	private SdIndexChar4Mapper sdIndexChar4Mapper;
	
	@Override
	public SdIndexChar4 getRecordByMail(String mail) throws Exception {
		SdIndexChar4Example example = new SdIndexChar4Example();
		example.createCriteria().andUserMailEqualTo(mail);
		List<SdIndexChar4> list = sdIndexChar4Mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
