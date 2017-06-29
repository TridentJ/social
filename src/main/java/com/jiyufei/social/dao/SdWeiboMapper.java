package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdWeibo;
import com.jiyufei.social.bean.SdWeiboExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdWeiboMapper {
    int countByExample(SdWeiboExample example);

    int deleteByExample(SdWeiboExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdWeibo record);

    int insertSelective(SdWeibo record);

    List<SdWeibo> selectByExample(SdWeiboExample example);

    SdWeibo selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdWeibo record, @Param("example") SdWeiboExample example);

    int updateByExample(@Param("record") SdWeibo record, @Param("example") SdWeiboExample example);

    int updateByPrimaryKeySelective(SdWeibo record);

    int updateByPrimaryKey(SdWeibo record);
}