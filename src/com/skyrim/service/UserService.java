package com.skyrim.service;

import java.util.List;

import com.skyrim.po.User;

public interface UserService {
	public void registUser(User user) throws Exception;

	public void deleteUser(Integer uid) throws Exception;

	// 检查用户名是否可用
	public boolean checkUser(String username) throws Exception;

	// 获取用户头像
	public String getUserImg(Integer uid) throws Exception;

	public void updateUserInfo(User user) throws Exception;

	public int findUidByUname(String uname) throws Exception;

	public User findUserByUid(Integer uid) throws Exception;

	public User findUserWithoutPasswdByUid(Integer uid) throws Exception;

	public String getNickname(Integer uid) throws Exception;

	// 检查昵称是否可用
	  
	public boolean checkNickName(String nickname) throws Exception;

	/** 
     * 检查密码是否正确 
     * @param checkPassword 
     * @return boolean
     */
	public boolean checkPassword(Integer uid,String password)throws Exception;
	
	public List<User> getalluser()throws Exception;
	
	
	
}
