package com.skyrim.service;

import java.util.Date;
import java.util.List;

import com.skyrim.po.Collect;

public interface CollectService {
	public void  addCollect(Integer uid,Integer vid,Date collectDate)throws Exception;
	
	public List<Collect> listCollects(Integer uid)throws Exception;
	
	public int numofCollect(Integer vid)throws Exception;
	
	public void removeCollect(Integer cid)throws Exception;

}
