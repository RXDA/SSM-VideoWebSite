package com.skyrim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.TagMapper;
import com.skyrim.po.Tag;
import com.skyrim.po.TagExample;
import com.skyrim.service.TagService;

@Service
public class TagServiceImpl implements TagService{

	@Autowired 
	private TagMapper tagMapper;
	
	@Override
	public void insertTag(Tag tag) throws Exception {
		tagMapper.insert(tag);
		
	}

	//获取视频的tag列表
	@Override
	public List<Tag> findTagByVid(Integer vid) throws Exception {
		TagExample tagExample=new TagExample();
		TagExample.Criteria criteria=tagExample.createCriteria();
		criteria.andVidEqualTo(vid);
		List<Tag> list=tagMapper.selectByExample(tagExample);
		return list;
	}

	@Override
	public void deleteTagByTid(Integer tid) throws Exception {
		tagMapper.deleteByPrimaryKey(tid);
		
	}

	@Override
	public Integer getVidByTid(Integer tid) throws Exception {
		Tag tag=tagMapper.selectByPrimaryKey(tid);
		int vid=tag.getVid();
		return vid;
	}

	@Override
	public List<Tag> findTagByTagText(String tagString) throws Exception {
		TagExample tagExample=new TagExample();
		TagExample.Criteria criteria=tagExample.createCriteria();
		criteria.andTagtextLike("%"+tagString+"%");
		List<Tag> list=tagMapper.selectByExample(tagExample);
		return list;
	}

}
