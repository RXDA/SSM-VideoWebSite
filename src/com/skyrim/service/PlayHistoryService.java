package com.skyrim.service;

import java.util.Date;
import java.util.List;

import com.skyrim.po.Playhistory;

public interface PlayHistoryService {
	
	public void addHistory(Integer uid,Integer vid,Date playDate)throws Exception;
	
	public void deleteHistory(Integer hid)throws Exception;
	
	public List<Playhistory> listHistoryByUid(Integer uid)throws Exception;

}
