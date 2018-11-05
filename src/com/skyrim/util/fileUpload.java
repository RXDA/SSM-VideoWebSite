package com.skyrim.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class fileUpload {
	public static String fileupload(MultipartFile file,String file_path) throws IllegalStateException, IOException{
		String originalFilename = file.getOriginalFilename();
		if (file != null && originalFilename != null&& originalFilename.length() > 0) {
			/*String pic_path = "F:\\skyrim\\img\\userhead\\";*/
			String newFileName = UUID.randomUUID()+ originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(file_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			// 将新图片名称写到itemsCustom中
			return newFileName;
		}
		
		
		return null;
		
		
		
		
	}
}
