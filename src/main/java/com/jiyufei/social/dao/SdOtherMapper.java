package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdOther;
import com.jiyufei.social.bean.SdOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdOtherMapper {
    int countByExample(SdOtherExample example);

    int deleteByExample(SdOtherExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdOther record);

    int insertSelective(SdOther record);

    List<SdOther> selectByExample(SdOtherExample example);

    SdOther selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdOther record, @Param("example") SdOtherExample example);

    int updateByExample(@Param("record") SdOther record, @Param("example") SdOtherExample example);

    int updateByPrimaryKeySelective(SdOther record);

    int updateByPrimaryKey(SdOther record);
}