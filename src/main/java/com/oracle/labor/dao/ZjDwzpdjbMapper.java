package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjDwzpdjb;
import com.oracle.labor.po.ZjDwzpdjbExample;

@Repository
public interface ZjDwzpdjbMapper {
    long countByExample(ZjDwzpdjbExample example);

    int deleteByExample(ZjDwzpdjbExample example);

    int insert(ZjDwzpdjb record);

    int insertSelective(ZjDwzpdjb record);

    List<ZjDwzpdjb> selectByExample(ZjDwzpdjbExample example);

    int updateByExampleSelective(@Param("record") ZjDwzpdjb record, @Param("example") ZjDwzpdjbExample example);

    int updateByExample(@Param("record") ZjDwzpdjb record, @Param("example") ZjDwzpdjbExample example);
}