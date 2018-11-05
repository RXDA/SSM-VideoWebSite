package com.skyrim.service;

import java.util.List;

import com.skyrim.po.Tag;

public interface TagService {
	
	public void insertTag(Tag tag)throws Exception;
	
	public List<Tag> findTagByVid(Integer vid)throws Exception;
	
	public void deleteTagByTid(Integer tid)throws Exception;
	
	public Integer getVidByTid(Integer tid) throws Exception;
	
	public List<Tag> findTagByTagText(String tagString)throws Exception;
}
