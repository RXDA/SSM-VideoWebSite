package com.skyrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ForwardController {
	
	/**
	 * 跳转至视频上传页
	 * @return
	 */
	@RequestMapping("/uploadpage")
	public String uploadpage(){
		return "redirect:/public/uploadvideo.jsp";
		
	}
	
	/**
	 * 跳转至视频上传成功页
	 * @return
	 */
	@RequestMapping("/videoredirect")
	public String videoredirect(){
		return "redirect:uploadsuccess.jsp";
		
		
		
	}
	

}
