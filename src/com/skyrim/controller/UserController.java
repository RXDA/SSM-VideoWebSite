package com.skyrim.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.skyrim.po.User;
import com.skyrim.service.FollowService;
import com.skyrim.service.UserService;
import com.skyrim.util.PasswordSalt;
import com.skyrim.util.fileUpload;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FollowService followService;
	

	 
	/**
	 * 用户注册
	 * @param user
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/regist")
	public String regist(User user) throws Exception {
		if (user.getUname() != "" && user.getUname() != null) {
			byte[] salt=PasswordSalt.getSaltOfASCII(20);
			String saltString=new String(salt,"UTF-8");
			String passwordString=PasswordSalt.toPasswd(user.getPassword(), salt);
			user.setPassword(passwordString);
			user.setUsalt(saltString);
			user.setPoint(0);
			user.setUimg("default.png");			
			userService.registUser(user);
			return "redirect:/index.jsp";
		} else {
			return "Username cannot be null";
		}
	}

	/**
	 * 检验用戶名是否可用
	 * @param request
	 * @param response
	 * @return Map
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkUserExist", produces = "application/json")
	public @ResponseBody Map<String, Object> checkUserExist(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("username")!=null&&request.getParameter("username")!=""){
		if (userService.checkUser(request.getParameter("username"))) {
			map.put("msg", "账户名可用");
		} else {
			map.put("msg", "账户名已被占用");
		}
		}else{
			map.put("msg", "");
		}
		return map;
	}
	
	/**
	 * 检验用戶名是否可用
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkNickExist", produces = "application/json")
	public @ResponseBody Map<String, Object> checkNickExist(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("nickname")!=null&&request.getParameter("nickname")!=""){
		if (userService.checkNickName(request.getParameter("nickname"))) {
			map.put("msg", "昵称可用");
		} else {
			map.put("msg", "昵称已被占用");
		}
		}else{
			map.put("msg", "");
			
		}
		return map;
	}

	/**
	 * 获取用户头像
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getUserImg", produces = "application/json")
	public @ResponseBody Map<String, Object> getUserImg(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		String imgurl = userService.getUserImg(Integer.parseInt(request
				.getParameter("uid")));
		if (!imgurl.equals(null)) {
			map.put("msg", imgurl);
		} else {
			map.put("msg", "/bysj/img/user_placeholder.png");
		}
		return map;
	}

	/**
	 * 用户资料页面
	 * @param model
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usercenter/{uid}")
	public String UserInfo(Model model, @PathVariable Integer uid)
			throws Exception {
		User user = userService.findUserByUid(uid);
		model.addAttribute("user", user);
		return "/public/profile.jsp";

	}

	/**
	 * 用户资料更新
	 * @param uid
	 * @param nickname
	 * @param sex
	 * @param uimg
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateuser")
	public String updateuser(Integer uid,String nickname,String sex,MultipartFile uimg,HttpSession session) throws Exception {

		User user=userService.findUserByUid(uid);
		user.setNickname(nickname);
		user.setSex(sex);
		
		
		String pic_path = "F:\\skyrim\\img\\userhead\\";
		String newFileNameString=fileUpload.fileupload(uimg, pic_path);
		user.setUimg(newFileNameString);
		
		userService.updateUserInfo(user);
		session.setAttribute("uimg", "http:\\\\127.0.0.1:8080\\img\\userhead\\"+userService.getUserImg(uid));
		
		return "redirect:/usercenter/"+uid;
	}
	
	
	/**
	 * 取得用户信息，不包括敏感信息，用于用户展示页面
	 * @param model
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userpage/{uid}")
	public String baseinfo(Model model,@PathVariable Integer uid) throws Exception{
		User user=userService.findUserWithoutPasswdByUid(uid);
		model.addAttribute("user", user);
		int fansNum=followService.findFansByUid(uid).size();
		int followNum=followService.findFollowByUid(uid).size();
		model.addAttribute("fansNum",fansNum);
		model.addAttribute("followNum",followNum);
		return "/public/userpage.jsp";
		
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @param uid
	 * @param oldpassword
	 * @param newpassword
	 * @param renewpassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="changepassword",produces = "application/json")
	public  @ResponseBody Map<String, Object> changepassword(HttpSession session,Integer uid,String oldpassword,String newpassword,String renewpassword)throws Exception{
		User user=userService.findUserByUid(uid);
		Map<String, Object> map = new HashMap<String, Object>();
		if(newpassword.equals(renewpassword)){
			if(userService.checkPassword(uid, oldpassword)){
				byte[] salt=PasswordSalt.getSaltOfASCII(20);
				String saltString=new String(salt,"UTF-8");
				String passwordString=PasswordSalt.toPasswd(newpassword, salt);
				user.setPassword(passwordString);
				user.setUsalt(saltString);
				userService.updateUserInfo(user);
				map.put("msg", "success");
			}else{
				map.put("msg", "原始密码错误");
				
			}
			
		}else{
			map.put("msg", "两次输入的密码不同");
		
		}
		session.invalidate();
		return map;		
	}
	
	
	@RequestMapping(value="getusernick/{uid}")
	public @ResponseBody  Map<String, Object> getusernick(@PathVariable Integer uid) throws Exception{
		User user=userService.findUserByUid(uid);
		String userNick=user.getNickname();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", userNick);
		return map;
		
		
		
		
	}
	
	@RequestMapping(value="getalluser")
	public @ResponseBody List<User> getalluser()throws Exception{
		List<User> list=userService.getalluser();
		return list;
		
		
		
	}
	
	@RequestMapping(value="deleteuser")
	public void deleteuser() throws Exception{
		
	}

}
