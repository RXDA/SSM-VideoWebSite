package com.skyrim.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyrim.mapper.VideoMapper;
import com.skyrim.mapper.VideoMapperCustom;
import com.skyrim.po.Video;
import com.skyrim.po.VideoExample;
import com.skyrim.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoMapper videomapper;
	@Autowired
	private VideoMapperCustom videoMapperCustom;
	
	

	@Override
	public Video findVideoById(Integer vid) throws Exception {
		Video video=videomapper.selectByPrimaryKey(vid);
		return video;
	}



	@Override
	public void uploadNewVideo(Video video) throws Exception {
		videomapper.insert(video);
		
	}



	@Override
	public Integer findVideoLastUpload(String vurl) throws Exception {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andVurlEqualTo(vurl);
		Video video=videomapper.selectByExample(videoExample).get(0);
		video.getVid();
		return video.getVid();
		
	}



	@Override
	public List<Video> findVideosByUp(Integer uid) throws Exception {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andSubuidEqualTo(uid);
		List<Video> list=videomapper.selectByExample(videoExample);
		return list;
	}


	//所谓的删除是将video的isdelete设置为true，恢复即为设置为false
	@Override
	public void deleteVideoByvid(Integer vid) throws Exception {
		Video video= videomapper.selectByPrimaryKey(vid);
		video.setIsdelete(true);
		videomapper.updateByPrimaryKeySelective(video);
		
	}



	@Override
	public void restoreVideoByvid(Integer vid) throws Exception {
		Video video= videomapper.selectByPrimaryKey(vid);
		video.setIsdelete(false);
		videomapper.updateByPrimaryKeySelective(video);
		
	}



	@Override
	public void updateVideo(Video video) throws Exception {
		videomapper.updateByPrimaryKey(video);
		
	}



	@Override
	public List<Video> findNotdeleteVideoByUp(Integer uid) throws Exception {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andSubuidEqualTo(uid);
		criteria.andIsdeleteEqualTo(false);
		List<Video> list=videomapper.selectByExample(videoExample);
		return list;
	}



	@Override
	public List<Video> searchVideosByTitle(String keyword) throws Exception {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andVtitleLike("%"+keyword+"%");	
		List<Video> list=videomapper.selectByExample(videoExample);
		return list;
	}



	@Override
	public List<Video> searchVideoByTitlewithType(String keyword, String type)
			throws Exception {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andVtitleLike("%"+keyword+"%");
		criteria.andVtypeEqualTo(type);
		List<Video> list=videomapper.selectByExample(videoExample);
		return list;
	}



	@Override
	public List<Video> searchVideoByIntroduce(String introduce)
			throws Exception {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andVintroduceLike("%"+introduce+"%");	
		List<Video> list=videomapper.selectByExample(videoExample);
		return list;
	}



	@Override
	public List<Video> listHotVideoWithType(String type, Integer limit)
			throws Exception {
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("type", type);
		hashMap.put("limit", limit);
		List<Video> list=videoMapperCustom.topVideoWithType(hashMap);
		return list;
	}



	@Override
	public List<Video> listLastUploadWithType(String type, Integer limit)
			throws Exception {
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("type", type);
		hashMap.put("limit", limit);
		List<Video> list=videoMapperCustom.LastVideoWithType(hashMap);
		return list;
	}




	
	
	

}
