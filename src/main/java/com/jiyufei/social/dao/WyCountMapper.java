package com.jiyufei.social.dao;

import com.jiyufei.social.bean.WyCount;
import com.jiyufei.social.bean.WyCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyCountMapper {
    int countByExample(WyCountExample example);

    int deleteByExample(WyCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyCount record);

    int insertSelective(WyCount record);

    List<WyCount> selectByExample(WyCountExample example);

    WyCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyCount record, @Param("example") WyCountExample example);

    int updateByExample(@Param("record") WyCount record, @Param("example") WyCountExample example);

    int updateByPrimaryKeySelective(WyCount record);

    int updateByPrimaryKey(WyCount record);
}