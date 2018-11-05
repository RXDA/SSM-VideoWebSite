package com.skyrim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyrim.po.Tag;
import com.skyrim.service.TagService;

@Controller
public class TagController {

	@Autowired
	private TagService tagService;
	
	/**
	 * 获取视频标签
	 * @param vid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/videotag/{vid}")
	public @ResponseBody List<Tag> videotag(@PathVariable Integer vid) throws Exception{
		List<Tag> tagList=tagService.findTagByVid(vid);
		return tagList;
	
	}
	
	/**
	 * 删除视频标签
	 * @param tid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="deletetag/{tid}")
	public String deletetag(@PathVariable Integer tid)throws Exception{
		int vid=tagService.getVidByTid(tid);
		tagService.deleteTagByTid(tid);
		return "redirect:/videoinfo/"+vid;
		
		
	}
	
	
}
