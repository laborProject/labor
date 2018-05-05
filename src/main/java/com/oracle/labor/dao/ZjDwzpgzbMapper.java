package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjDwzpgzb;
import com.oracle.labor.po.ZjDwzpgzbExample;

@Repository
public interface ZjDwzpgzbMapper {
    long countByExample(ZjDwzpgzbExample example);

    int deleteByExample(ZjDwzpgzbExample example);

    int insert(ZjDwzpgzb record);

    int insertSelective(ZjDwzpgzb record);

    List<ZjDwzpgzb> selectByExample(ZjDwzpgzbExample example);

    int updateByExampleSelective(@Param("record") ZjDwzpgzb record, @Param("example") ZjDwzpgzbExample example);

    int updateByExample(@Param("record") ZjDwzpgzb record, @Param("example") ZjDwzpgzbExample example);
}