package com.skyrim.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.po.Collect;
import com.skyrim.service.CollectService;

@Controller
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value="addcollect")
	public void addcollect(Integer uid,Integer vid)throws Exception{
		Date date=new Date();
		if(uid!=null){			
			collectService.addCollect(uid, vid, date);			
		}		
	};
	
	@RequestMapping(value="listcollect",produces = "application/json")
	public @ResponseBody List<Collect> listcollect(Integer uid) throws Exception{
		List<Collect> list= collectService.listCollects(uid);
		return list;
		
	}

	@RequestMapping(value="deletecollect")
	public void deletecollect(Integer cid)throws Exception{
		collectService.removeCollect(cid);
		
		
	}
}
