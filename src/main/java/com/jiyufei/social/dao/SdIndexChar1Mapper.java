package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdIndexChar1;
import com.jiyufei.social.bean.SdIndexChar1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdIndexChar1Mapper {
    int countByExample(SdIndexChar1Example example);

    int deleteByExample(SdIndexChar1Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdIndexChar1 record);

    int insertSelective(SdIndexChar1 record);

    List<SdIndexChar1> selectByExample(SdIndexChar1Example example);

    SdIndexChar1 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdIndexChar1 record, @Param("example") SdIndexChar1Example example);

    int updateByExample(@Param("record") SdIndexChar1 record, @Param("example") SdIndexChar1Example example);

    int updateByPrimaryKeySelective(SdIndexChar1 record);

    int updateByPrimaryKey(SdIndexChar1 record);
}