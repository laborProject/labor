package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.ZjTjxxhzb;
import com.oracle.labor.po.ZjTjxxhzbExample;

@Repository
public interface ZjTjxxhzbMapper {
    long countByExample(ZjTjxxhzbExample example);

    int deleteByExample(ZjTjxxhzbExample example);

    int insert(ZjTjxxhzb record);

    int insertSelective(ZjTjxxhzb record);

    List<ZjTjxxhzb> selectByExample(ZjTjxxhzbExample example);

    int updateByExampleSelective(@Param("record") ZjTjxxhzb record, @Param("example") ZjTjxxhzbExample example);

    int updateByExample(@Param("record") ZjTjxxhzb record, @Param("example") ZjTjxxhzbExample example);
}