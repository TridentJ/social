package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdIndexNum;
import com.jiyufei.social.bean.SdIndexNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdIndexNumMapper {
    int countByExample(SdIndexNumExample example);

    int deleteByExample(SdIndexNumExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdIndexNum record);

    int insertSelective(SdIndexNum record);

    List<SdIndexNum> selectByExample(SdIndexNumExample example);

    SdIndexNum selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdIndexNum record, @Param("example") SdIndexNumExample example);

    int updateByExample(@Param("record") SdIndexNum record, @Param("example") SdIndexNumExample example);

    int updateByPrimaryKeySelective(SdIndexNum record);

    int updateByPrimaryKey(SdIndexNum record);
}