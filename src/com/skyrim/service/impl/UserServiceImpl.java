package com.skyrim.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.UserMapperCustom;
import com.skyrim.mapper.UserMapper;
import com.skyrim.po.User;
import com.skyrim.po.UserExample;
import com.skyrim.service.UserService;
import com.skyrim.util.PasswordSalt;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Override
	public void registUser(User user) throws Exception {
		usermapper.insert(user);
		
		
	}

	@Override
	public void deleteUser(Integer uid) throws Exception {
		usermapper.deleteByPrimaryKey(uid);
		
	}

	@Override
	public boolean checkUser(String username) throws Exception {
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andUnameEqualTo(username);
		int usernumber=usermapper.countByExample(userExample);
		if(usernumber==0){
			//用户名可以使用
			return true;
		}
		else {
			//用户名已占用
			return false;
		}
		
	}
	
	//获取用户头像
	@Override
	public String getUserImg(Integer uid) throws Exception {
		User user=usermapper.selectByPrimaryKey(uid);
		String imgurl=user.getUimg();
		return imgurl;
	}

	@Override
	public void updateUserInfo(User user) throws Exception {
	
		//usermapper.updateByPrimaryKey(user); 会将没有的值赋值为null
		usermapper.updateByPrimaryKeySelective(user);
		
		
	}

	@Override
	public int findUidByUname(String uname) throws Exception {
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andUnameEqualTo(uname);
		List<User> user=usermapper.selectByExample(userExample);
		int uid=user.get(0).getUid();
		return uid;
	}

	@Override
	public User findUserByUid(Integer uid) throws Exception {
		User user=usermapper.selectByPrimaryKey(uid);
		return user;
	}

	@Override
	public String getNickname(Integer uid) throws Exception {
		User user=usermapper.selectByPrimaryKey(uid);
		String nickName=user.getNickname();
		return nickName;
	}

	//获取不包含敏感信息的用户信息
	@Override
	public User findUserWithoutPasswdByUid(Integer uid) throws Exception {
		User user=userMapperCustom.selectByPrimaryKey(uid);
		return user;
	}

	@Override
	public boolean checkNickName(String nickname) throws Exception {
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andNicknameEqualTo(nickname);
		int usernumber=usermapper.countByExample(userExample);
		if(usernumber==0){
			//昵称可以使用
			return true;
		}
		else {
			//昵称已占用
			return false;
		}
		
	}

	@Override
	public boolean checkPassword(Integer uid, String password) throws Exception {
		User user=usermapper.selectByPrimaryKey(uid);
		byte[] salt=user.getUsalt().getBytes("UTF8");
		String passwordSaltString=PasswordSalt.toPasswd(password,salt);
		if (user.getPassword().equals(passwordSaltString)) {
			return true;
		} else {
			return false;
		}
		 
	}

	@Override
	public List<User> getalluser() throws Exception {
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andNicknameLike("%%");
		List<User> list=usermapper.selectByExample(userExample);
		return list;
	}

	
	
	

}
