package com.asva.service.upload;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.asva.model.UploadDetail;
	
public interface UploadService {
	
	/***
	 * Upload file to server
	 * @return Upload Detail Object
	 */
	UploadDetail upload(MultipartFile file, HttpServletRequest request);
	
	/***
	 * Upload to specific folder
	 * @param file
	 * @param request
	 * @param folder
	 * @return Upload Detail Object
	 */
	UploadDetail uploadToFolder(MultipartFile file, HttpServletRequest request, String folder);
	
	List<String> uploadMultiple(List<MultipartFile> file, HttpServletRequest request);
	
}
