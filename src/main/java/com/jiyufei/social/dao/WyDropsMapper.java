package com.jiyufei.social.dao;

import com.jiyufei.social.bean.WyDrops;
import com.jiyufei.social.bean.WyDropsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyDropsMapper {
    int countByExample(WyDropsExample example);

    int deleteByExample(WyDropsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyDrops record);

    int insertSelective(WyDrops record);

    List<WyDrops> selectByExampleWithBLOBs(WyDropsExample example);

    List<WyDrops> selectByExample(WyDropsExample example);

    WyDrops selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyDrops record, @Param("example") WyDropsExample example);

    int updateByExampleWithBLOBs(@Param("record") WyDrops record, @Param("example") WyDropsExample example);

    int updateByExample(@Param("record") WyDrops record, @Param("example") WyDropsExample example);

    int updateByPrimaryKeySelective(WyDrops record);

    int updateByPrimaryKeyWithBLOBs(WyDrops record);

    int updateByPrimaryKey(WyDrops record);
}