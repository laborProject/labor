package com.oracle.labor.dao;

import com.oracle.labor.po.CdgEducationallevel;
import com.oracle.labor.po.CdgEducationallevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CdgEducationallevelMapper {
    long countByExample(CdgEducationallevelExample example);

    int deleteByExample(CdgEducationallevelExample example);

    int insert(CdgEducationallevel record);

    int insertSelective(CdgEducationallevel record);

    List<CdgEducationallevel> selectByExample(CdgEducationallevelExample example);

    int updateByExampleSelective(@Param("record") CdgEducationallevel record, @Param("example") CdgEducationallevelExample example);

    int updateByExample(@Param("record") CdgEducationallevel record, @Param("example") CdgEducationallevelExample example);
}