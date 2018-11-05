package com.skyrim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.FollowMapper;
import com.skyrim.po.Follow;
import com.skyrim.po.FollowExample;
import com.skyrim.service.FollowService;
import com.skyrim.service.UserService;

@Service
public class FollowServiceImpl implements FollowService{
	
	@Autowired
	private FollowMapper followMapper;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Follow> findFansByUid(Integer uid1) throws Exception {
		FollowExample followExample=new FollowExample();
		FollowExample.Criteria criteria=followExample.createCriteria();
		criteria.andUid1EqualTo(uid1);		
		//uid2是uid1的粉丝
		List<Follow> list =followMapper.selectByExample(followExample);
		
	
		return list;
	}

	
	@Override
	public List<Follow> findFollowByUid(Integer uid2) throws Exception {
		FollowExample followExample=new FollowExample();
		FollowExample.Criteria criteria=followExample.createCriteria();
		criteria.andUid2EqualTo(uid2);		
		//uid2是uid1的粉丝,查询uid2可得到所有uid2关注的用户
		List<Follow> list =followMapper.selectByExample(followExample);

		return list;
	}

    //关注
	@Override
	public void beFans(Integer uid2, Integer uid1) throws Exception {
		FollowExample followExample=new FollowExample();
		FollowExample.Criteria criteria=followExample.createCriteria();
		criteria.andUid2EqualTo(uid2);
		criteria.andUid1EqualTo(uid1);
		if(followMapper.selectByExample(followExample).isEmpty()){
		Follow follow =new Follow();
		follow.setUid1(uid1);
		follow.setUid2(uid2);
		followMapper.insert(follow);
		}
	}

	//取关
	@Override
	public void beNotFans(Integer uid2, Integer uid1) throws Exception {
		FollowExample followExample=new FollowExample();
		FollowExample.Criteria criteria=followExample.createCriteria();
		criteria.andUid2EqualTo(uid2);
		criteria.andUid1EqualTo(uid1);
		followMapper.deleteByExample(followExample);
		
	}


	@Override
	public boolean checkFollow(Integer uid1, Integer uid2) throws Exception {
		FollowExample followExample=new FollowExample();
		FollowExample.Criteria criteria=followExample.createCriteria();
		criteria.andUid2EqualTo(uid2);
		criteria.andUid1EqualTo(uid1);
		if(followMapper.selectByExample(followExample).isEmpty()){
			return false;
		}else{
			return true;
		}
		
	}

}
