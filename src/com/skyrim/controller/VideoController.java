package com.skyrim.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
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
import org.springframework.web.servlet.ModelAndView;

import com.skyrim.po.Tag;
import com.skyrim.po.User;
import com.skyrim.po.Video;
import com.skyrim.service.FollowService;
import com.skyrim.service.HotWordService;
import com.skyrim.service.TagService;
import com.skyrim.service.UserService;
import com.skyrim.service.VideoService;
import com.skyrim.util.fileUpload;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;

	@Autowired
	private TagService tagService;

	@Autowired
	private UserService userService;

	@Autowired
	private FollowService followService;
	
	@Autowired
	private HotWordService hotWordService;
	


	/**
	 * 视频上传
	 * 
	 * @param request
	 * @param response
	 * @param vtitle
	 * @param subuid
	 * @param vtype
	 * @param vcover
	 * @param vurl
	 * @param tagString
	 * @param vdate
	 * @param vintroduce
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,
			HttpServletResponse response, String vtitle, Integer subuid,
			String vtype, MultipartFile vcover, MultipartFile vurl,
			String tagString, Date vdate, String vintroduce, HttpSession session)
			throws Exception {
		Video video = new Video();

		video.setVtitle(vtitle);
		video.setSubuid(subuid);
		video.setVtype(vtype);
		video.setVplaytime(0);
		video.setVcoll(0);
		video.setVintroduce(vintroduce);
		video.setIsdelete(false);
		// 使用自定义工具类上传
		video.setVurl(fileUpload.fileupload(vurl, "F:\\skyrim\\video\\"));
		video.setVcover(fileUpload.fileupload(vcover,
				"F:\\skyrim\\img\\videocover\\"));
		video.setVdate(vdate);
		videoService.uploadNewVideo(video);
		int vidlastupload = videoService.findVideoLastUpload(video.getVurl());

		// 标签上传
		String tag[] = tagString.split(",");
		for (int i = 0; i < tag.length; i++) {
			Tag tagInsert = new Tag();
			tagInsert.setVid(vidlastupload);
			tagInsert.setTagtext(tag[i]);
			tagService.insertTag(tagInsert);

		}
		session.setAttribute("vid", vidlastupload);
		return "redirect:/public/uploadsuccess.jsp";

	}

	/**
	 * 用户的视频管理
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/videomanagelist")
	public @ResponseBody List<Video> videomanagelist(
			HttpServletRequest request, HttpSession session) throws Exception {
		int uid = (int) session.getAttribute("uid");
		// 只查找isdelete=false的video
		List<Video> videoList = videoService.findNotdeleteVideoByUp(uid);
		return videoList;

	}

	/**
	 * 用户删除视频
	 * 
	 * @param vid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deletevideo/{vid}")
	public String deletevideo(@PathVariable Integer vid, HttpSession session)
			throws Exception {

		if ((int) session.getAttribute("uid") == videoService
				.findVideoById(vid).getSubuid()) {
			videoService.deleteVideoByvid(vid);
			return "redirect:/public/videomanage.jsp";
		} else {
			return "redirect:/public/videomanage.jsp";

		}

	}

	/**
	 * 恢复视频
	 * 
	 * @param vid
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/restorevideo/{vid}")
	public void restorevideo(@PathVariable Integer vid, HttpSession session)
			throws Exception {
		if (session.getAttribute("uid") == videoService.findVideoById(vid)
				.getSubuid()) {
			videoService.restoreVideoByvid(vid);
		}

	}

	/**
	 * 视频信息编辑
	 * 
	 * @param vid
	 * @param session
	 * @param vtitle
	 * @param vtype
	 * @param tagString
	 * @param vintroduce
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatevideo/{vid}")
	public String editvideo(@PathVariable Integer vid, HttpSession session,
			String vtitle, String vtype, String tagString, String vintroduce)
			throws Exception {
		if (Integer.parseInt(session.getAttribute("uid").toString()) == videoService
				.findVideoById(vid).getSubuid()) {
			Video video = videoService.findVideoById(vid);
			video.setVtitle(vtitle);
			video.setVtype(vtype);
			video.setVintroduce(vintroduce);
			if (tagString != null) {
				String tag[] = tagString.split(",");
				for (int i = 0; i < tag.length; i++) {
					Tag tagInsert = new Tag();
					tagInsert.setVid(vid);
					tagInsert.setTagtext(tag[i]);
					tagService.insertTag(tagInsert);
				}
			}
			videoService.updateVideo(video);
		}
		return "redirect:/public/videomanage.jsp";

	}

	/**
	 * 获取视频信息
	 * 
	 * @param model
	 * @param vid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/videoinfo/{vid}")
	public String videoinfo(Model model, @PathVariable Integer vid,
			HttpSession session) throws Exception {
		if (Integer.parseInt(session.getAttribute("uid").toString()) == videoService
				.findVideoById(vid).getSubuid()) {
			Video video = videoService.findVideoById(vid);
			model.addAttribute("video", video);
			session.setAttribute("videoInfovid", vid);
			return "/public/editvideo.jsp";

		} else {
			return null;

		}
	}

	/**
	 * 用户视频列表
	 * 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/videolist/{uid}")
	public @ResponseBody List<Video> videolist(@PathVariable Integer uid)
			throws Exception {
		List<Video> list = videoService.findVideosByUp(uid);
		return list;

	}

	/**
	 * 视频播放页
	 * 
	 * @param model
	 * @param vid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/video/{vid}")
	public String video(Model model, @PathVariable Integer vid)
			throws Exception {

		Video video = videoService.findVideoById(vid);
		User user = userService.findUserWithoutPasswdByUid(video.getSubuid());
		int fansNumber = followService.findFansByUid(user.getUid()).size();
		model.addAttribute("video", video);
		model.addAttribute("uper", user);
		model.addAttribute("fansNumber", fansNumber);

		return "/public/video.jsp";

	}

	/**
	 * 播放次数增加
	 * 
	 * @param vid
	 * @throws Exception
	 */
	@RequestMapping(value = "/addplaytime/{vid}")
	public void addplaytime(@PathVariable Integer vid) throws Exception {
		Video video = videoService.findVideoById(vid);
		int vplaytime = video.getVplaytime() + 1;
		video.setVplaytime(vplaytime);
		videoService.updateVideo(video);

	}

	/**
	 * 以关键字搜索视频，包括tag
	 * 
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value = "/searchvideo/keyword={keyword}", produces = "application/json")
	public @ResponseBody List<Video> searchvideo(@PathVariable String keyword)
			throws Exception {
		List<Video> list = videoService.searchVideosByTitle(keyword);
		List<Tag> tagList = tagService.findTagByTagText(keyword);
		List<Video> fromTagsearchList = new ArrayList<Video>();
		List<Video> fromIntroduceList = videoService
				.searchVideoByIntroduce(keyword);
		if (!tagList.isEmpty()) {
			for (int i = 0; i < tagList.size(); i++) {
				Video video = videoService.findVideoById(tagList.get(i)
						.getVid());
				fromTagsearchList.add(video);
			}

		}
		// 去重合并List
		list.removeAll(fromTagsearchList);
		list.removeAll(fromIntroduceList);
		fromTagsearchList.removeAll(fromIntroduceList);
		list.addAll(fromTagsearchList);
		list.addAll(fromIntroduceList);

		
		 * Set<Video> set =new HashSet<>(); set.addAll(list);
		 * set.addAll(fromTagsearchList); List<Video> resultList =new
		 * ArrayList<>(set);
		 
		if (list.isEmpty()) {
			return null;
		} else {
			return list;

		}

	}*/

	/**
	 * 按视频分类及标题搜索视频
	 * 
	 * @param keyword
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchvideo",produces = "application/json")
	public @ResponseBody List<Video> searchvideo( String keyword,String type) throws Exception {
		hotWordService.insertWord(keyword);
		List<Video> list = new ArrayList<Video>();
		list = videoService.searchVideosByTitle(keyword);
		List<Tag> tagList = tagService.findTagByTagText(keyword);
		List<Video> fromTagsearchList = new ArrayList<Video>();
		List<Video> fromIntroduceList = videoService
				.searchVideoByIntroduce(keyword);
		if (!tagList.isEmpty()) {
			for (int i = 0; i < tagList.size(); i++) {
				Video video = videoService.findVideoById(tagList.get(i)
						.getVid());
				fromTagsearchList.add(video);
			}

		}
		// 去重合并List
		list.removeAll(fromTagsearchList);
		list.removeAll(fromIntroduceList);
		fromTagsearchList.removeAll(fromIntroduceList);
		list.addAll(fromTagsearchList);
		list.addAll(fromIntroduceList);
		
		/*
		 * Set<Video> set =new HashSet<>(); set.addAll(list);
		 * set.addAll(fromTagsearchList); List<Video> resultList =new
		 * ArrayList<>(set);
		 */
		if (list.isEmpty()) {
			return null;
		} else {
			if (!type.equals("全部")) {	
				for(int i=list.size()-1;i>=0;i--){
					if (!list.get(i).getVtype().equals(type)) {
						list.remove(i);
					}					
				}
				if(list.size()==0){
					return null;
				}
				}
			}
			return list;

		}
	
	
	
	/**
	 * 各区排行
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="video/top",produces = "application/json")
	public @ResponseBody List<Video> listVideoWithType(Integer type,Integer limit) throws Exception{
		
		String typename="";
		switch (type) {
		case 0:break;
		case 1:typename="动画";break;
		case 2:typename="音乐";break;
		case 3:typename="科技";break;
		case 4:typename="娱乐";break;
		case 5:typename="电影";break;
		case 6:typename="游戏";break;	
		default:
			break;
		}
		List<Video> list=videoService.listHotVideoWithType(typename,limit);
		return list;
				
	}
	
	@RequestMapping(value="video/new",produces = "application/json")
	public @ResponseBody List<Video> listNewVideoWithType(Integer type,Integer limit) throws Exception{
		
		String typename="";
		switch (type) {
		case 0:break;
		case 1:typename="动画";break;
		case 2:typename="音乐";break;
		case 3:typename="科技";break;
		case 4:typename="娱乐";break;
		case 5:typename="电影";break;
		case 6:typename="游戏";break;	
		default:
			break;
		}
		
		List<Video> list=videoService.listLastUploadWithType(typename,limit);		
		return list;
				
	}
	
	
	@RequestMapping(value="type={type}",produces = "application/json")
	public String typeRedirect(@PathVariable String type,HttpSession session) throws Exception{
		
		session.setAttribute("type", type);
		int typeId = 0;
		switch (type) {
		case "animation":typeId=1;break;
		case "music":typeId=2;break;
		case "tec":typeId=3;break;
		case "ent":typeId=4;break;
		case "movie":typeId=5;break;
		case "game":typeId=6;break;

		default:
			break;
		}
		session.setAttribute("typeId", typeId);
		
		return "/public/type.jsp";
				
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="video/topyestoday",produces = "application/json")
	public @ResponseBody List<Video> listTodayHot(Integer type,Integer limit) throws Exception{
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefore = calendar.getTime();
		String typename="";
		switch (type) {
		case 0:break;
		case 1:typename="动画";break;
		case 2:typename="音乐";break;
		case 3:typename="科技";break;
		case 4:typename="娱乐";break;
		case 5:typename="电影";break;
		case 6:typename="游戏";break;	
		default:
			break;
		}
		List<Video> list=videoService.listHotVideoWithType(typename,limit);
		int size=list.size();
		for(int i=size-1;i>=0;i--){
			Date date=list.get(i).getVdate();
			if(date.getYear()!=dNow.getYear()||date.getMonth()!=dNow.getMonth()||date.getDay()!=dNow.getDay()){
				list.remove(i);
				
			}
			
			
		}
		
		
		return list;
				
	}
	
	@RequestMapping(value="getvideotitle/{vid}")
	public @ResponseBody  Map<String, Object> getvideotitle(@PathVariable Integer vid) throws Exception{
		Video video=videoService.findVideoById(vid);
		String title=video.getVtitle();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", title);
		return map;
	
	

    }
	
	@RequestMapping(value="videorecommend")	
	public @ResponseBody List<Video> videorecommend()throws Exception{
		List<Video> list=new ArrayList<Video>();		
		
		
		
		return null;
		
	}
	
	
}


