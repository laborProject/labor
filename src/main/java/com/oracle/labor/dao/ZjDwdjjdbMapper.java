package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjDwdjjdb;
import com.oracle.labor.po.ZjDwdjjdbExample;

@Repository
public interface ZjDwdjjdbMapper {
    long countByExample(ZjDwdjjdbExample example);

    int deleteByExample(ZjDwdjjdbExample example);

    int insert(ZjDwdjjdb record);

    int insertSelective(ZjDwdjjdb record);

    List<ZjDwdjjdb> selectByExample(ZjDwdjjdbExample example);

    int updateByExampleSelective(@Param("record") ZjDwdjjdb record, @Param("example") ZjDwdjjdbExample example);

    int updateByExample(@Param("record") ZjDwdjjdb record, @Param("example") ZjDwdjjdbExample example);
}