package com.jiyufei.social.dao;

import com.jiyufei.social.bean.WyHistory;
import com.jiyufei.social.bean.WyHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyHistoryMapper {
    int countByExample(WyHistoryExample example);

    int deleteByExample(WyHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyHistory record);

    int insertSelective(WyHistory record);

    List<WyHistory> selectByExample(WyHistoryExample example);

    WyHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyHistory record, @Param("example") WyHistoryExample example);

    int updateByExample(@Param("record") WyHistory record, @Param("example") WyHistoryExample example);

    int updateByPrimaryKeySelective(WyHistory record);

    int updateByPrimaryKey(WyHistory record);
}