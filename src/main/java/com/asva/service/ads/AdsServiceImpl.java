package com.asva.service.ads;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asva.model.ads.Ads;
import com.asva.repository.AdsRepository;
import com.asva.util.filter.AdsFilter;
import com.asva.util.paging.Paging;

@Service
public class AdsServiceImpl implements AdsService {

	@Autowired
	private AdsRepository adsRepository;

	@Override
	public ArrayList<Ads> findAll(AdsFilter filter, Paging paging) {
		try {
			paging.setTotalCount(adsRepository.count(filter));
			return adsRepository.findAll(filter, paging);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ads findOne(int id) {
		try {
			return adsRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		try {
			return adsRepository.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean save(Ads ads) {
		try {
			return adsRepository.save(ads);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Ads ads) {
		try {
			return adsRepository.update(ads);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean toggleStatus(int id) {
		try {
			return adsRepository.toggleStatus(id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}

}
