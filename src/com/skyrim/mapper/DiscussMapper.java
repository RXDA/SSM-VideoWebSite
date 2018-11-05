package com.skyrim.mapper;

import com.skyrim.po.Discuss;
import com.skyrim.po.DiscussExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscussMapper {
    int countByExample(DiscussExample example);

    int deleteByExample(DiscussExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Discuss record);

    int insertSelective(Discuss record);

    List<Discuss> selectByExampleWithBLOBs(DiscussExample example);

    List<Discuss> selectByExample(DiscussExample example);

    Discuss selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Discuss record, @Param("example") DiscussExample example);

    int updateByExampleWithBLOBs(@Param("record") Discuss record, @Param("example") DiscussExample example);

    int updateByExample(@Param("record") Discuss record, @Param("example") DiscussExample example);

    int updateByPrimaryKeySelective(Discuss record);

    int updateByPrimaryKeyWithBLOBs(Discuss record);

    int updateByPrimaryKey(Discuss record);
}