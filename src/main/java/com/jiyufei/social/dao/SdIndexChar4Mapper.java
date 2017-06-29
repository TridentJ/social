package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdIndexChar4;
import com.jiyufei.social.bean.SdIndexChar4Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdIndexChar4Mapper {
    int countByExample(SdIndexChar4Example example);

    int deleteByExample(SdIndexChar4Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdIndexChar4 record);

    int insertSelective(SdIndexChar4 record);

    List<SdIndexChar4> selectByExample(SdIndexChar4Example example);

    SdIndexChar4 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdIndexChar4 record, @Param("example") SdIndexChar4Example example);

    int updateByExample(@Param("record") SdIndexChar4 record, @Param("example") SdIndexChar4Example example);

    int updateByPrimaryKeySelective(SdIndexChar4 record);

    int updateByPrimaryKey(SdIndexChar4 record);
}