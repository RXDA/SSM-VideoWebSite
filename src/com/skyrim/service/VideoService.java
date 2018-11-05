package com.skyrim.service;

import java.util.List;

import com.skyrim.po.Video;


public interface VideoService {
		
	public Video findVideoById(Integer vid)throws Exception;
	
	public void uploadNewVideo(Video video)throws Exception;
	
	public Integer findVideoLastUpload(String vurl)throws Exception;
	
	public List<Video> findVideosByUp(Integer uid)throws Exception;
	
	public void deleteVideoByvid(Integer vid)throws Exception;
	
	public void restoreVideoByvid(Integer vid)throws Exception;
	
	public void updateVideo(Video video)throws Exception;
	
	public List<Video> findNotdeleteVideoByUp(Integer uid)throws Exception;
	
	public List<Video> searchVideosByTitle(String keyword)throws Exception;
	
	public List<Video> searchVideoByTitlewithType(String keyword,String type)throws Exception;
	
	public List<Video> searchVideoByIntroduce(String introduce)throws Exception;
	
	public List<Video> listHotVideoWithType(String type,Integer limit)throws Exception;
	
	public List<Video> listLastUploadWithType(String type,Integer limit)throws Exception;

	
}
