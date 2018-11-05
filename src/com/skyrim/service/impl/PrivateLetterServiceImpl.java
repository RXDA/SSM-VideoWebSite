package com.skyrim.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.PrivateletterMapper;
import com.skyrim.po.Privateletter;
import com.skyrim.po.PrivateletterExample;
import com.skyrim.service.PrivateLetterService;

@Service
public class PrivateLetterServiceImpl implements PrivateLetterService{
	
	@Autowired
	private PrivateletterMapper privateletterMapper;

	@Override
	public List<Privateletter> receiveLetter(Integer receiverUid) throws Exception {
		PrivateletterExample privateletterExample=new PrivateletterExample();
		PrivateletterExample.Criteria criteria=privateletterExample.createCriteria();
		criteria.andReceiveruidEqualTo(receiverUid);
		List<Privateletter> list=privateletterMapper.selectByExample(privateletterExample);		
		return list;
	
	}

	@Override
	public void sendLetter(Privateletter privateletter)throws Exception {
		privateletter.setIsread(false);
		privateletterMapper.insert(privateletter);
		
		
	}

	@Override
	public void setLetterReaded(Integer pid) throws Exception {
		Privateletter privateletter=privateletterMapper.selectByPrimaryKey(pid);
		privateletter.setIsread(true);
		privateletterMapper.updateByPrimaryKey(privateletter);
		
	}

}
