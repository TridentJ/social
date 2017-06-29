package com.jiyufei.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jiyufei.social.bean.SocialRecord;
import com.jiyufei.social.dao.SocialRecordMapper;

/*
 *Created by jiyufei on 2016年11月1日 上午9:26:29 .
 */
@Service("socialRecordService")
public class SocialRecordServiceImpl implements SocialRecordService {

	@Autowired
	private SocialRecordMapper socialRecordMapper;
	
	@Override
	public SocialRecord getRecord() throws Exception {
		SocialRecord socialRecord = socialRecordMapper.selectByPrimaryKey(1);
		return socialRecord;
	}

	@Override
	public Integer updateRecord(SocialRecord socialRecord) throws Exception {
		Integer result = socialRecordMapper.updateByPrimaryKeySelective(socialRecord);
		return result;
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Integer upSocialRecordNum(Integer hit) throws Exception {
		SocialRecord socialRecord = socialRecordMapper.selectByPrimaryKey(new Integer(1));
		int newSelectNum = 0;
		int newHitNum = 0;
		if(socialRecord != null){
			newSelectNum = socialRecord.getSelectNum() + 1;
			if(hit == 1){
				newHitNum = socialRecord.getHitNum() + 1;
			}else{
				newHitNum = socialRecord.getHitNum();
			}
			SocialRecord record = new SocialRecord();
			record.setId(1);
			record.setSelectNum(newSelectNum);
			record.setHitNum(newHitNum);
			int result = socialRecordMapper.updateByPrimaryKeySelective(record);
			return result;
		}
		return 0;
	}

}
