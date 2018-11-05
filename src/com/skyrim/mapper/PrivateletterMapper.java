package com.skyrim.mapper;

import com.skyrim.po.Privateletter;
import com.skyrim.po.PrivateletterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivateletterMapper {
    int countByExample(PrivateletterExample example);

    int deleteByExample(PrivateletterExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Privateletter record);

    int insertSelective(Privateletter record);

    List<Privateletter> selectByExample(PrivateletterExample example);

    Privateletter selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Privateletter record, @Param("example") PrivateletterExample example);

    int updateByExample(@Param("record") Privateletter record, @Param("example") PrivateletterExample example);

    int updateByPrimaryKeySelective(Privateletter record);

    int updateByPrimaryKey(Privateletter record);
}