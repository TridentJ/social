package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdRenren;
import com.jiyufei.social.bean.SdRenrenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdRenrenMapper {
    int countByExample(SdRenrenExample example);

    int deleteByExample(SdRenrenExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdRenren record);

    int insertSelective(SdRenren record);

    List<SdRenren> selectByExample(SdRenrenExample example);

    SdRenren selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdRenren record, @Param("example") SdRenrenExample example);

    int updateByExample(@Param("record") SdRenren record, @Param("example") SdRenrenExample example);

    int updateByPrimaryKeySelective(SdRenren record);

    int updateByPrimaryKey(SdRenren record);
}