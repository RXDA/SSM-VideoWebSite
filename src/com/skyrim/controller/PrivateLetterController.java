package com.skyrim.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.custompo.PrivateLetterAndUser;
import com.skyrim.po.Privateletter;
import com.skyrim.service.PrivateLetterService;
import com.skyrim.service.UserService;

@Controller
public class PrivateLetterController {
	
	@Autowired
	private PrivateLetterService privateLetterService;
	@Autowired
	private UserService userService;
	
	/**
	 * 获取私信
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getletter/{uid}")
	public @ResponseBody List<PrivateLetterAndUser> getletter(@PathVariable Integer uid) throws Exception{
		List<Privateletter> list=privateLetterService.receiveLetter(uid);
		List<PrivateLetterAndUser> returnList=new ArrayList<PrivateLetterAndUser>();
		//扩展po类
		PrivateLetterAndUser privateLetterAndUser = new PrivateLetterAndUser();
		for(int i=0;i<list.size();i++){
			privateLetterAndUser.setPid(list.get(i).getPid());
			privateLetterAndUser.setSenderuid(list.get(i).getSenderuid());
			privateLetterAndUser.setReceiveruid(list.get(i).getReceiveruid());
			privateLetterAndUser.setMessage(list.get(i).getMessage());
			privateLetterAndUser.setIsread(list.get(i).getIsread());
			String senderNickname=userService.getNickname(list.get(i).getSenderuid());
			privateLetterAndUser.setNickname(senderNickname);
			returnList.add(privateLetterAndUser);
			privateLetterAndUser = new PrivateLetterAndUser();
			
		}
		return returnList;
		
	}
	
	/**
	 * 发送私信
	 * @param request
	 * @param response
	 * @param senderuid
	 * @param receiveruid
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sendletter",produces = "application/json")
	public @ResponseBody Map<String, Object> sendletter(HttpServletRequest request,HttpServletResponse response,Integer senderuid,Integer receiveruid,String message,Date sendDate)throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		Privateletter privateletter=new Privateletter();
		privateletter.setSenderuid(senderuid);
		privateletter.setReceiveruid(receiveruid);
		privateletter.setMessage(message);
		privateLetterService.sendLetter(privateletter);
		map.put("msg", "success");
		return map;
	
	}
	
	/**
	 * 阅读私信
	 * @param pid
	 * @throws Exception
	 */
	@RequestMapping(value="/readletter")
	public void readletter(Integer pid)throws Exception{
	privateLetterService.setLetterReaded(pid);

	}
	
	/**
	 * 写私信
	 * @param model
	 * @param receiveruid
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/writeletter/{receiveruid}")
	public String writeletter(Model model,@PathVariable Integer receiveruid) throws Exception{
		String receivernickname=userService.getNickname(receiveruid);
		model.addAttribute("receivernickname",receivernickname);
		model.addAttribute("receiveruid",receiveruid);
		return "/public/writeletter.jsp";
		
		
		
		
	}

}
