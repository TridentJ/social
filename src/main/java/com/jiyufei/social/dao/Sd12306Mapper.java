package com.jiyufei.social.dao;

import com.jiyufei.social.bean.Sd12306;
import com.jiyufei.social.bean.Sd12306Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sd12306Mapper {
    int countByExample(Sd12306Example example);

    int deleteByExample(Sd12306Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Sd12306 record);

    int insertSelective(Sd12306 record);

    List<Sd12306> selectByExample(Sd12306Example example);

    Sd12306 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Sd12306 record, @Param("example") Sd12306Example example);

    int updateByExample(@Param("record") Sd12306 record, @Param("example") Sd12306Example example);

    int updateByPrimaryKeySelective(Sd12306 record);

    int updateByPrimaryKey(Sd12306 record);
}