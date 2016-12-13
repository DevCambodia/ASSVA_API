package com.asva.service.adsdetail;

import java.util.ArrayList;

import com.asva.model.ads.AdsDetail;

public interface AdsDetailService {
	/***
	 * 
	 * @return
	 */
	ArrayList<AdsDetail> findAll();
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	AdsDetail findOne(int id);
}
