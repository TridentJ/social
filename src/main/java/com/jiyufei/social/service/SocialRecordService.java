package com.jiyufei.social.service;


import com.jiyufei.social.bean.SocialRecord;

/*
 *Created by jiyufei on 2016年11月1日 上午9:16:38 .
 */

public interface SocialRecordService {
	
	public SocialRecord getRecord() throws Exception;
	
	public Integer updateRecord(SocialRecord socialRecord) throws Exception;
	
	public Integer upSocialRecordNum(Integer hit) throws Exception;
}
