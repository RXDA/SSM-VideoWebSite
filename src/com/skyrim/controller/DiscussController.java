package com.skyrim.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.custompo.DiscussAndUser;
import com.skyrim.po.Discuss;
import com.skyrim.po.User;
import com.skyrim.service.DiscussService;
import com.skyrim.service.UserService;

@Controller
public class DiscussController {
	@Autowired
	private DiscussService discussService;
	
	@Autowired
	private UserService userService;

	/**
	 * 添加评论
	 * 
	 * @param uid
	 * @param vid
	 * @param newDiscuss
	 * @throws Exception
	 */
	@RequestMapping(value="/addDiscuss",produces = "application/json")
	public void addNewDiscuss(Integer uid,Integer vid,String newDiscuss)throws Exception{
		discussService.insertDiscuss(uid, vid, newDiscuss);
	}
	
	/**
	 * 获取用户评论及评论用户的信息
	 * @param vid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listDiscuss/{vid}")
	public @ResponseBody List<DiscussAndUser> listDiscuss(@PathVariable Integer vid)throws Exception{
		List<Discuss> list=discussService.findDiscussByVid(vid);
		List<DiscussAndUser> discussList=new ArrayList<DiscussAndUser>();
		for(int i=0;i<list.size();i++){
			Discuss discuss=list.get(i);
			DiscussAndUser discusswithuser=new DiscussAndUser();
			int uid=discuss.getUid();
			User user=userService.findUserWithoutPasswdByUid(uid);
			discusswithuser.setDid(discuss.getDid());
			discusswithuser.setDiscusstext(discuss.getDiscusstext());
			discusswithuser.setUid(uid);
			discusswithuser.setVid(discuss.getVid());
			discusswithuser.setUimg(user.getUimg());
			discusswithuser.setNickname(user.getNickname());
			discussList.add(discusswithuser);
			
		}
		return discussList;
		
	}
		
}

