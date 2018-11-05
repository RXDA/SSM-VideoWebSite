package com.skyrim.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.po.Playhistory;
import com.skyrim.service.PlayHistoryService;

@Controller
public class PlayHistoryController {
	
	@Autowired
	private PlayHistoryService playHistoryService;
	
	@RequestMapping(value="addhistory")
	public void addHistory(Integer uid,Integer vid)throws Exception{
		Date date=new Date();
		if(uid!=null){			
			playHistoryService.addHistory(uid, vid, date);			
		}		
	};
	
	
	@RequestMapping(value="listhistory",produces = "application/json")
	public @ResponseBody List<Playhistory> listhistory(Integer uid) throws Exception{
		List<Playhistory> list= playHistoryService.listHistoryByUid(uid);
		return list;
		
	}
	
	@RequestMapping(value="deletehistory")
	public void deletehistory(Integer hid)throws Exception{
		playHistoryService.deleteHistory(hid);
		
		
	}
	

}
