package com.skyrim.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.CollectMapper;
import com.skyrim.po.Collect;
import com.skyrim.po.CollectExample;
import com.skyrim.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService{
	
	@Autowired
	private CollectMapper collectMapper;

	@Override
	public void addCollect(Integer uid, Integer vid,Date collectDate) throws Exception {
		Collect collect=new Collect();
		collect.setUid(uid);
		collect.setVid(vid);
		collect.setCollectdate(collectDate);
		collectMapper.insert(collect);
	}

	@Override
	public List<Collect> listCollects(Integer uid) throws Exception {
		CollectExample example=new CollectExample();
		CollectExample.Criteria criteria=example.createCriteria();
		criteria.andUidEqualTo(uid);
		List<Collect> list =collectMapper.selectByExample(example);
		return list;
	}

	@Override
	public int numofCollect(Integer vid) throws Exception {
		CollectExample example=new CollectExample();
		CollectExample.Criteria criteria=example.createCriteria();
		criteria.andVidEqualTo(vid);
		List<Collect> list =collectMapper.selectByExample(example);
		return list.size();
		
	}

	@Override
	public void removeCollect(Integer cid) throws Exception {
		collectMapper.deleteByPrimaryKey(cid);
		
	}
	
	

}
