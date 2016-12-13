package com.asva.service.adsdetail;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asva.model.ads.AdsDetail;
import com.asva.repository.AdsDetailRepository;
	
@Service
public class AdsDetailServiceImpl implements AdsDetailService{

	@Autowired
	private AdsDetailRepository adsDetailRepository;
	
	@Override
	public ArrayList<AdsDetail> findAll() {
		return adsDetailRepository.findAll();
	}

	@Override
	public AdsDetail findOne(int id) {
		return adsDetailRepository.findOne(id);
	}

}
