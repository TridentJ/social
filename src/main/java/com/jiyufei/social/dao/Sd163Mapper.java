package com.jiyufei.social.dao;

import com.jiyufei.social.bean.Sd163;
import com.jiyufei.social.bean.Sd163Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sd163Mapper {
    int countByExample(Sd163Example example);

    int deleteByExample(Sd163Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Sd163 record);

    int insertSelective(Sd163 record);

    List<Sd163> selectByExample(Sd163Example example);

    Sd163 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Sd163 record, @Param("example") Sd163Example example);

    int updateByExample(@Param("record") Sd163 record, @Param("example") Sd163Example example);

    int updateByPrimaryKeySelective(Sd163 record);

    int updateByPrimaryKey(Sd163 record);
}