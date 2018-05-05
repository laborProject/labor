package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjGrqzdjjdb;
import com.oracle.labor.po.ZjGrqzdjjdbExample;

@Repository
public interface ZjGrqzdjjdbMapper {
    long countByExample(ZjGrqzdjjdbExample example);

    int deleteByExample(ZjGrqzdjjdbExample example);

    int insert(ZjGrqzdjjdb record);

    int insertSelective(ZjGrqzdjjdb record);

    List<ZjGrqzdjjdb> selectByExample(ZjGrqzdjjdbExample example);

    int updateByExampleSelective(@Param("record") ZjGrqzdjjdb record, @Param("example") ZjGrqzdjjdbExample example);

    int updateByExample(@Param("record") ZjGrqzdjjdb record, @Param("example") ZjGrqzdjjdbExample example);
}