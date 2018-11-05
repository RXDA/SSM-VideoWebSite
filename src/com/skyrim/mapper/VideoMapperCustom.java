package com.skyrim.mapper;

import com.skyrim.po.Video;

import java.util.HashMap;
import java.util.List;

public interface VideoMapperCustom {
    List<Video> topVideoWithType(HashMap<String, Object> hashMap);
    
    List<Video> LastVideoWithType(HashMap<String, Object> hashMap);
}