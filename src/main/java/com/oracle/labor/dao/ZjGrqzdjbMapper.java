package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjGrqzdjb;
import com.oracle.labor.po.ZjGrqzdjbExample;

@Repository
public interface ZjGrqzdjbMapper {
    long countByExample(ZjGrqzdjbExample example);

    int deleteByExample(ZjGrqzdjbExample example);

    int insert(ZjGrqzdjb record);

    int insertSelective(ZjGrqzdjb record);

    List<ZjGrqzdjb> selectByExample(ZjGrqzdjbExample example);

    int updateByExampleSelective(@Param("record") ZjGrqzdjb record, @Param("example") ZjGrqzdjbExample example);

    int updateByExample(@Param("record") ZjGrqzdjb record, @Param("example") ZjGrqzdjbExample example);
}