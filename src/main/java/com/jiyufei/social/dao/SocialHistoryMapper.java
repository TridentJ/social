package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SocialHistory;
import com.jiyufei.social.bean.SocialHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocialHistoryMapper {
    int countByExample(SocialHistoryExample example);

    int deleteByExample(SocialHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SocialHistory record);

    int insertSelective(SocialHistory record);

    List<SocialHistory> selectByExample(SocialHistoryExample example);

    SocialHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SocialHistory record, @Param("example") SocialHistoryExample example);

    int updateByExample(@Param("record") SocialHistory record, @Param("example") SocialHistoryExample example);

    int updateByPrimaryKeySelective(SocialHistory record);

    int updateByPrimaryKey(SocialHistory record);
}