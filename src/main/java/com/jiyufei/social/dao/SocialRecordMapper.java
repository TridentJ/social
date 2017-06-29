package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SocialRecord;
import com.jiyufei.social.bean.SocialRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocialRecordMapper {
    int countByExample(SocialRecordExample example);

    int deleteByExample(SocialRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SocialRecord record);

    int insertSelective(SocialRecord record);

    List<SocialRecord> selectByExample(SocialRecordExample example);

    SocialRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SocialRecord record, @Param("example") SocialRecordExample example);

    int updateByExample(@Param("record") SocialRecord record, @Param("example") SocialRecordExample example);

    int updateByPrimaryKeySelective(SocialRecord record);

    int updateByPrimaryKey(SocialRecord record);
}