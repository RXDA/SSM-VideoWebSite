package com.skyrim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.DiscussMapper;
import com.skyrim.po.Discuss;
import com.skyrim.po.DiscussExample;
import com.skyrim.service.DiscussService;

@Service
public class DiscussServiceImpl implements DiscussService{

	@Autowired
	private DiscussMapper discussMapper;

	@Override
	public void insertDiscuss(Integer uid, Integer vid, String discussString) throws Exception{
		Discuss discuss=new Discuss();
		discuss.setUid(uid);
		discuss.setVid(vid);
		discuss.setDiscusstext(discussString);
		discussMapper.insert(discuss);
		
	}

	@Override
	public List<Discuss> findDiscussByVid(Integer vid) throws Exception {
		DiscussExample example=new DiscussExample();
		DiscussExample.Criteria criteria=example.createCriteria();
		criteria.andVidEqualTo(vid);
		List<Discuss> list=discussMapper.selectByExampleWithBLOBs(example);
		return list;
	}

}
