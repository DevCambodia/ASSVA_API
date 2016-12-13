package com.asva.service.upload;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asva.model.UploadDetail;

@Service
public class UploadServiceImpl implements UploadService {
	
	private UploadDetail uploadDetail = new UploadDetail();
	
	@Override
	public UploadDetail upload(MultipartFile file, HttpServletRequest request) {
		
		String RELATIVE_PATH = "/resources/upload/";
		
		String UPLOAD_PATH = request.getSession()
							 .getServletContext()
							 .getRealPath(RELATIVE_PATH);
		File path = new File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		if (!file.isEmpty()) {
			String fileName = UUID.randomUUID() + "." +  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			try {
				Files.copy(file.getInputStream(), 
						Paths.get(UPLOAD_PATH, fileName));
				
				uploadDetail.setRelativePath(RELATIVE_PATH);
				uploadDetail.setFileName(fileName);
				System.out.println("==>" + fileName);
			} catch (Exception e) {
				uploadDetail.setError(e.getMessage());
			}
		} else {
			uploadDetail.setError("File is empty!");
		}
		return uploadDetail;
	}

	
	@Override
	public List<String> uploadMultiple(List<MultipartFile> files, HttpServletRequest request) {
		
		String RELATIVE_PATH = "/resources/upload/";
		String UPLOAD_PATH = request.getSession().getServletContext().getRealPath(RELATIVE_PATH);
		System.out.println(UPLOAD_PATH);
		File path = new File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		if (!files.isEmpty()) {
			List<String> filesName = new ArrayList<>();
			for(MultipartFile file: files){
				String fileName = UUID.randomUUID() + "." +  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				try {
					Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
					filesName.add(RELATIVE_PATH + fileName);
					
				} catch (Exception e) {
					uploadDetail.setError(e.getMessage());
				}
			}
			return filesName;
		} else {
			uploadDetail.setError("File is empty!");
		}
		return null;
	}
	
	@Override
	public UploadDetail uploadToFolder(MultipartFile file, HttpServletRequest request, String folder) {
		
		String RELATIVE_PATH = "/resources/" + folder + "/";
		String UPLOAD_PATH = request.getSession()
				 			 .getServletContext()
				 			 .getRealPath(RELATIVE_PATH);
		
	    File path = new File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		if (!file.isEmpty()) {
			String fileName = UUID.randomUUID() + "." +  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			try {
				Files.copy(file.getInputStream(), 
						Paths.get(UPLOAD_PATH, fileName));
				
				uploadDetail.setRelativePath(RELATIVE_PATH);
				uploadDetail.setFileName(fileName);
				System.out.println("==>" + fileName);
				
			} catch (Exception e) {
				uploadDetail.setError(e.getMessage());
			}
		} else {
			uploadDetail.setError("File is empty!");
		}
		return uploadDetail;	
	}
}
