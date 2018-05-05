package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjGrqzgzb;
import com.oracle.labor.po.ZjGrqzgzbExample;

@Repository
public interface ZjGrqzgzbMapper {
    long countByExample(ZjGrqzgzbExample example);

    int deleteByExample(ZjGrqzgzbExample example);

    int insert(ZjGrqzgzb record);

    int insertSelective(ZjGrqzgzb record);

    List<ZjGrqzgzb> selectByExample(ZjGrqzgzbExample example);

    int updateByExampleSelective(@Param("record") ZjGrqzgzb record, @Param("example") ZjGrqzgzbExample example);

    int updateByExample(@Param("record") ZjGrqzgzb record, @Param("example") ZjGrqzgzbExample example);
}