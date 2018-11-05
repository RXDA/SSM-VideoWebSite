package com.skyrim.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.service.LoginService;
import com.skyrim.service.UserService;

@Controller
public class LoginContorller {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;

	/**
	 * 用戶登录
	 * @param session
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpSession session, String uname, String password)
			throws Exception {
		int uid=userService.findUidByUname(uname);
		String nickname=userService.getNickname(uid);
		session.setAttribute("username", uname);
		session.setAttribute("nickname", nickname);
		session.setAttribute("uid", uid);
		session.setAttribute("uimg", "http:\\\\127.0.0.1:8080\\img\\userhead\\"+userService.getUserImg(uid));
		return "redirect:/public/loginsuccess.jsp";

	}
	
	/**
	 * 检验用户名和密码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkUserLogin", produces = "application/json")
	public @ResponseBody Map<String, Object> checkUserExist(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String checkResult = loginService.checkpassword(uname, password);
		if (uname != null) {
			if (checkResult != "usernotfound") {
				if (checkResult == "success") {
					map.put("msg", "1");
				} else {
					map.put("msg", "0");
				}

			} else {
				map.put("msg", "0");
			}
		} else {
			map.put("msg", "2");
		}
		return map;
	}

	/**
	 * 退出登陆
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		session.invalidate();
		return "redirect:/index.jsp";
	}

}
