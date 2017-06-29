package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SocialCount;
import com.jiyufei.social.bean.SocialCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocialCountMapper {
    int countByExample(SocialCountExample example);

    int deleteByExample(SocialCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SocialCount record);

    int insertSelective(SocialCount record);

    List<SocialCount> selectByExample(SocialCountExample example);

    SocialCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SocialCount record, @Param("example") SocialCountExample example);

    int updateByExample(@Param("record") SocialCount record, @Param("example") SocialCountExample example);

    int updateByPrimaryKeySelective(SocialCount record);

    int updateByPrimaryKey(SocialCount record);
}