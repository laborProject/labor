package com.oracle.labor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labor.po.Bip;
import com.oracle.labor.po.BipExample;

@Repository
public interface BipMapper {
    long countByExample(BipExample example);

    int deleteByExample(BipExample example);

    int insert(Bip record);

    int insertSelective(Bip record);

    List<Bip> selectByExample(BipExample example);

    int updateByExampleSelective(@Param("record") Bip record, @Param("example") BipExample example);

    int updateByExample(@Param("record") Bip record, @Param("example") BipExample example);
}