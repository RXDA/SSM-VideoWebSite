package com.skyrim.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.PlayhistoryMapper;
import com.skyrim.po.Playhistory;
import com.skyrim.po.PlayhistoryExample;
import com.skyrim.service.PlayHistoryService;

@Service
public class PlayHistoryserviceImpl implements PlayHistoryService {
	
	@Autowired
	private PlayhistoryMapper playhistoryMapper;

	@Override
	public void addHistory(Integer uid, Integer vid,Date playDate) throws Exception{
		Playhistory history=new Playhistory();
		history.setUid(uid);
		history.setVid(vid);
		history.setPlaydate(playDate);
		playhistoryMapper.insert(history);
		
	}

	@Override
	public void deleteHistory(Integer hid) throws Exception{
		playhistoryMapper.deleteByPrimaryKey(hid);
		
	}

	@Override
	public List<Playhistory> listHistoryByUid(Integer uid) throws Exception {
		PlayhistoryExample example=new PlayhistoryExample();
		PlayhistoryExample.Criteria criteria=example.createCriteria();
		criteria.andUidEqualTo(uid);
		List<Playhistory> list=playhistoryMapper.selectByExample(example);
		return list;
	}

}
