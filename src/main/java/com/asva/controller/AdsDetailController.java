package com.asva.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asva.model.ads.AdsDetail;
import com.asva.service.adsdetail.AdsDetailService;
import com.asva.util.response.ResponseCode;
import com.asva.util.response.ResponseList;
import com.asva.util.response.ResponseRecord;

@RestController
@RequestMapping("/api/adsdetail")
public class AdsDetailController {

	@Autowired
	private AdsDetailService adsDetailService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseList<AdsDetail> findAll(){
		ResponseList<AdsDetail> response = new ResponseList<>();
		ArrayList<AdsDetail> adsDetail = adsDetailService.findAll(); 
		if(adsDetail.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
			return response;
		}
		response.setCode(ResponseCode.RECORD_FOUND);
		response.setData(adsDetail);
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseRecord<AdsDetail> findOne(@PathVariable("id") int id){
		ResponseRecord<AdsDetail> response = new ResponseRecord<>();
		AdsDetail adsDetail = adsDetailService.findOne(id);
		if(adsDetail==null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
			return response;
		}
		response.setData(adsDetail);
		response.setCode(ResponseCode.RECORD_FOUND);
		return response;
	}
	
	
}
