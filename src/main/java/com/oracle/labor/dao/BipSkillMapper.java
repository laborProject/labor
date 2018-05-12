package com.oracle.labor.dao;

import com.oracle.labor.po.BipSkill;
import com.oracle.labor.po.BipSkillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BipSkillMapper {
    long countByExample(BipSkillExample example);

    int deleteByExample(BipSkillExample example);

    int insert(BipSkill record);

    int insertSelective(BipSkill record);

    List<BipSkill> selectByExample(BipSkillExample example);

    int updateByExampleSelective(@Param("record") BipSkill record, @Param("example") BipSkillExample example);

    int updateByExample(@Param("record") BipSkill record, @Param("example") BipSkillExample example);
}