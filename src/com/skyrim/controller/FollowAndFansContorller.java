package com.skyrim.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.po.Follow;
import com.skyrim.po.User;
import com.skyrim.service.FollowService;
import com.skyrim.service.UserService;

@Controller
public class FollowAndFansContorller {
	@Autowired
	private FollowService followService;

	@Autowired
	private UserService userService;

	/**
	 * 找到id为“uid”的用户的订阅者，即粉丝
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fans/{uid}")
	public @ResponseBody List<User> fans(@PathVariable Integer uid) throws Exception {
		List<Follow> list = followService.findFansByUid(uid);
		
		List<User> userlist = new ArrayList<User>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				User user=userService.findUserWithoutPasswdByUid(list.get(i).getUid2());

				userlist.add(user);
			}
		}

		return userlist;

	}

	/**
	 * 找到id为“uid”的用户订阅的用户，即关注
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/subscript/{uid}")
	public @ResponseBody List<User> subscript(@PathVariable Integer uid) throws Exception {
		List<Follow> list = followService.findFollowByUid(uid);
		List<User> userlist = new ArrayList<User>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				User user=userService.findUserWithoutPasswdByUid(list.get(i).getUid1());

				userlist.add(user);
			}
		}

		return userlist;

	}
	
	/**
	 * 成爲粉絲
	 * @param uid1
	 * @param uid2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/befan",produces = "application/json")
	public @ResponseBody Map<String, Object> befan(Integer uid1,Integer uid2) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		followService.beFans(uid2, uid1);
		int number=followService.findFansByUid(uid1).size();
		map.put("msg", "success");
		map.put("number",number);
		return map;
		
	}
	
	
	/**
	 * 取消關注
	 * @param uid1
	 * @param uid2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/nolongerfan",produces = "application/json")
	public @ResponseBody Map<String, Object> nolongerfan(Integer uid1,Integer uid2) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		followService.beNotFans(uid2, uid1);
		map.put("msg", "success");
		return map;
		
	}

	/**
	 * 检测是否有关注关系
	 * @param uid1
	 * @param uid2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="checkfollow",produces = "application/json")
	public @ResponseBody Map<String, Object> checkfollow(Integer uid1,Integer uid2) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(followService.checkFollow(uid1, uid2)){
		map.put("msg", "true");
		}else{
		map.put("msg", "false");	
		}
		return map;
		
	}

}
