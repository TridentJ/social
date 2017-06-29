package com.jiyufei.social.dao;

import com.jiyufei.social.bean.SdCsdn;
import com.jiyufei.social.bean.SdCsdnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdCsdnMapper {
    int countByExample(SdCsdnExample example);

    int deleteByExample(SdCsdnExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SdCsdn record);

    int insertSelective(SdCsdn record);

    List<SdCsdn> selectByExample(SdCsdnExample example);

    SdCsdn selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SdCsdn record, @Param("example") SdCsdnExample example);

    int updateByExample(@Param("record") SdCsdn record, @Param("example") SdCsdnExample example);

    int updateByPrimaryKeySelective(SdCsdn record);

    int updateByPrimaryKey(SdCsdn record);
}