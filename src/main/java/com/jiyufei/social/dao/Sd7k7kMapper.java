package com.jiyufei.social.dao;

import com.jiyufei.social.bean.Sd7k7k;
import com.jiyufei.social.bean.Sd7k7kExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sd7k7kMapper {
    int countByExample(Sd7k7kExample example);

    int deleteByExample(Sd7k7kExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Sd7k7k record);

    int insertSelective(Sd7k7k record);

    List<Sd7k7k> selectByExample(Sd7k7kExample example);

    Sd7k7k selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Sd7k7k record, @Param("example") Sd7k7kExample example);

    int updateByExample(@Param("record") Sd7k7k record, @Param("example") Sd7k7kExample example);

    int updateByPrimaryKeySelective(Sd7k7k record);

    int updateByPrimaryKey(Sd7k7k record);
}