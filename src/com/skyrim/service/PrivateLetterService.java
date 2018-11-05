package com.skyrim.service;



import java.util.List;

import com.skyrim.po.Privateletter;

public interface PrivateLetterService {
	
	//查收私信，需要的参数：接收者id
	public List<Privateletter> receiveLetter(Integer receiverUid)throws Exception;
	
	
	//发送私信，需要的参数：Us1(senderuid)发给User2(receiverUid),私信内容
	public void sendLetter(Privateletter privateletter)throws Exception;
	
	//设置私信为已读
	public void setLetterReaded(Integer pid)throws Exception;
	

}
