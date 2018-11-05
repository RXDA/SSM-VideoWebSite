package com.skyrim.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.DailyhotwordMapper;
import com.skyrim.po.Dailyhotword;
import com.skyrim.po.DailyhotwordExample;
import com.skyrim.service.HotWordService;

@Service
public class HotWordServiceImpl implements HotWordService{
	
	@Autowired
	private DailyhotwordMapper dailyhotwordMapper;

	@Override
	public void insertWord(String word) throws Exception {
		Dailyhotword hotword=new Dailyhotword();
		String[] array=word.split(" ");

		
		DailyhotwordExample example=new DailyhotwordExample();
		DailyhotwordExample.Criteria criteria=example.createCriteria();
		criteria.andHotwordidGreaterThan(-1);		
		List<Dailyhotword> list=dailyhotwordMapper.selectByExample(example);
	    int size=list.size();
		for(int i=0;i<array.length;i++){
			for(int j=0;j<size;j++){
				Dailyhotword w=list.get(j);
				if(w.getHotword()==array[i]){
					w.setTimes(w.getTimes()+1);
				}else{
					hotword.setHotword(array[i]);
					hotword.setTimes(1);
					list.add(hotword);					
				}				
			}		
		}
		
	}

	@Override
	public void clearTable() throws Exception {
		DailyhotwordExample example=new DailyhotwordExample();
		DailyhotwordExample.Criteria criteria=example.createCriteria();
		criteria.andHotwordidGreaterThan(-1);		
		dailyhotwordMapper.deleteByExample(example);
		
		
		
	}

}
