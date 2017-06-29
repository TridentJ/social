package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdZhenai;
import com.jiyufei.social.bean.SdZhenaiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdZhenaiMapper {
    int countByExample(SdZhenaiExample example);

    int deleteByExample(SdZhenaiExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdZhenai record);

    int insertSelective(SdZhenai record);

    List<SdZhenai> selectByExample(SdZhenaiExample example);

    SdZhenai selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdZhenai record, @Param("example") SdZhenaiExample example);

    int updateByExample(@Param("record") SdZhenai record, @Param("example") SdZhenaiExample example);

    int updateByPrimaryKeySelective(SdZhenai record);

    int updateByPrimaryKey(SdZhenai record);
}