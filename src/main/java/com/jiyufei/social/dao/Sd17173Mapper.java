package com.jiyufei.social.dao;

import com.jiyufei.social.bean.Sd17173;
import com.jiyufei.social.bean.Sd17173Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sd17173Mapper {
    int countByExample(Sd17173Example example);

    int deleteByExample(Sd17173Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Sd17173 record);

    int insertSelective(Sd17173 record);

    List<Sd17173> selectByExample(Sd17173Example example);

    Sd17173 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Sd17173 record, @Param("example") Sd17173Example example);

    int updateByExample(@Param("record") Sd17173 record, @Param("example") Sd17173Example example);

    int updateByPrimaryKeySelective(Sd17173 record);

    int updateByPrimaryKey(Sd17173 record);
}