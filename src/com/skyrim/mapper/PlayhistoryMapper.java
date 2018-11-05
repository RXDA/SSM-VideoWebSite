package com.skyrim.mapper;

import com.skyrim.po.Playhistory;
import com.skyrim.po.PlayhistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayhistoryMapper {
    int countByExample(PlayhistoryExample example);

    int deleteByExample(PlayhistoryExample example);

    int deleteByPrimaryKey(Integer hid);

    int insert(Playhistory record);

    int insertSelective(Playhistory record);

    List<Playhistory> selectByExample(PlayhistoryExample example);

    Playhistory selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Playhistory record, @Param("example") PlayhistoryExample example);

    int updateByExample(@Param("record") Playhistory record, @Param("example") PlayhistoryExample example);

    int updateByPrimaryKeySelective(Playhistory record);

    int updateByPrimaryKey(Playhistory record);
}