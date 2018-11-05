package com.skyrim.mapper;

import com.skyrim.po.Dailyhotword;
import com.skyrim.po.DailyhotwordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyhotwordMapper {
    int countByExample(DailyhotwordExample example);

    int deleteByExample(DailyhotwordExample example);

    int deleteByPrimaryKey(Integer hotwordid);

    int insert(Dailyhotword record);

    int insertSelective(Dailyhotword record);

    List<Dailyhotword> selectByExample(DailyhotwordExample example);

    Dailyhotword selectByPrimaryKey(Integer hotwordid);

    int updateByExampleSelective(@Param("record") Dailyhotword record, @Param("example") DailyhotwordExample example);

    int updateByExample(@Param("record") Dailyhotword record, @Param("example") DailyhotwordExample example);

    int updateByPrimaryKeySelective(Dailyhotword record);

    int updateByPrimaryKey(Dailyhotword record);
}