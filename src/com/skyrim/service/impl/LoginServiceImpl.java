package com.skyrim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.UserMapper;
import com.skyrim.po.User;
import com.skyrim.po.UserExample;
import com.skyrim.service.LoginService;
import com.skyrim.util.PasswordSalt;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper usermapper;

	@Override
	public String checkpassword(String uname, String password) throws Exception {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUnameEqualTo(uname);
		
		List<User> userList = usermapper.selectByExample(userExample);
		if (usermapper.countByExample(userExample)!= 0) {
			User user = userList.get(0);
			byte[] salt=user.getUsalt().getBytes("UTF8");
			String passwordSaltString=PasswordSalt.toPasswd(password,salt);
			if (user.getPassword().equals(passwordSaltString)) {
				return "success";
			} else {
				return "fail";
			}

		} else {
			return "usernotfound";
		}
	}

}
