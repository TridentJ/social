package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdIndexChar2;
import com.jiyufei.social.bean.SdIndexChar2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdIndexChar2Mapper {
    int countByExample(SdIndexChar2Example example);

    int deleteByExample(SdIndexChar2Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdIndexChar2 record);

    int insertSelective(SdIndexChar2 record);

    List<SdIndexChar2> selectByExample(SdIndexChar2Example example);

    SdIndexChar2 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdIndexChar2 record, @Param("example") SdIndexChar2Example example);

    int updateByExample(@Param("record") SdIndexChar2 record, @Param("example") SdIndexChar2Example example);

    int updateByPrimaryKeySelective(SdIndexChar2 record);

    int updateByPrimaryKey(SdIndexChar2 record);
}