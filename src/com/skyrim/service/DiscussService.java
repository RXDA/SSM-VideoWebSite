package com.skyrim.service;

import java.util.List;

import com.skyrim.po.Discuss;

public interface DiscussService {
	public void insertDiscuss(Integer uid,Integer vid,String discussString) throws Exception;
	
	public List<Discuss> findDiscussByVid(Integer vid)throws Exception;
}
