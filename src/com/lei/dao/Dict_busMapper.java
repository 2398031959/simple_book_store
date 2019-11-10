package com.lei.dao;

import com.lei.po.Dict_bus;
import com.lei.po.Dict_busExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Dict_busMapper {
    long countByExample(Dict_busExample example);

    int deleteByExample(Dict_busExample example);

    int deleteByPrimaryKey(Integer dId);

    int insert(Dict_bus record);

    int insertSelective(Dict_bus record);

    List<Dict_bus> selectByExample(Dict_busExample example);

    Dict_bus selectByPrimaryKey(Integer dId);

    int updateByExampleSelective(@Param("record") Dict_bus record, @Param("example") Dict_busExample example);

    int updateByExample(@Param("record") Dict_bus record, @Param("example") Dict_busExample example);

    int updateByPrimaryKeySelective(Dict_bus record);

    int updateByPrimaryKey(Dict_bus record);
}