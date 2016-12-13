package com.asva.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asva.model.UploadDetail;
import com.asva.service.upload.UploadService;
import com.asva.util.response.ResponseCode;
import com.asva.util.response.ResponseList;
import com.asva.util.response.ResponseRecord;

import io.swagger.annotations.ApiOperation;

/***
 * 
 * @author PHEARUN
 *
 */

@RestController
@RequestMapping("/api/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	/***
	 * Upload file
	 * 
	 * @param file
	 * @param request
	 * @return fileName
	 */
	@ApiOperation("Upload file to default folder(/resources/upload)")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseRecord<UploadDetail> uploadFile(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		
		ResponseRecord<UploadDetail> response = new ResponseRecord<>();
		response.setCode(ResponseCode.SUCCESS);
		response.setData(uploadService.upload(file, request));

		return response;
	}

	/***
	 * Upload to specific folder
	 * 
	 * @param folder
	 * @param file
	 * @param request
	 * @return
	 */
	@ApiOperation("Upload file to specific folder(/resources/{folder}/{**})")
	@RequestMapping(value = "/folder", method = RequestMethod.POST)
	public ResponseRecord<UploadDetail> uploadFileToFolder(@RequestParam("folder") String folder,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		ResponseRecord<UploadDetail> response = new ResponseRecord<>();
		response.setCode(ResponseCode.SUCCESS);
		response.setData(uploadService.uploadToFolder(file, request, folder));

		return response;
	}
	
	
	@ApiOperation("Upload multiple file")
	@RequestMapping(value = "/multiple", method = RequestMethod.POST)
	public ResponseList<String> uploadMultiple(@RequestParam(value = "file", required = false) List<MultipartFile> files, HttpServletRequest request) {
		System.out.println("==>>" + files.size());
		ResponseList<String> response = new ResponseList<>();
		if(files.isEmpty()){
			response.setCode(ResponseCode.FAIL);
			return response; 
		}
		List<String> fileList = uploadService.uploadMultiple(files, request);
		if(fileList.isEmpty()){
			response.setCode(ResponseCode.FAIL);
			return response;
		}
		response.setCode(ResponseCode.SUCCESS);
		response.setData(fileList);
		
		return response;
	}

}
