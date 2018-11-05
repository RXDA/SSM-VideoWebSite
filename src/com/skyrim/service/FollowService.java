package com.skyrim.service;

import java.util.List;

import com.skyrim.po.Follow;

public interface FollowService {
	//查询粉丝
	public List<Follow> findFansByUid(Integer uid1) throws Exception;
	
	//查询关注
	public List<Follow> findFollowByUid(Integer uid2) throws Exception;
	
	//uid2 成为uid1的粉丝
	public void beFans(Integer uid2,Integer uid1) throws Exception;
	//uid2 不再是uid1的粉丝
	public void beNotFans(Integer uid2,Integer uid1)throws Exception;
	
	public boolean checkFollow(Integer uid1,Integer uid2)throws Exception;
}
