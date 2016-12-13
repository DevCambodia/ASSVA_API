package com.asva.service.ads;

import java.util.ArrayList;

import com.asva.model.ads.Ads;
import com.asva.util.filter.AdsFilter;
import com.asva.util.paging.Paging;

public interface AdsService {
	
	/***
	 * Get All Ads With Pagination and Filter
	 * @param filter
	 * @param paging
	 * @return
	 */
	ArrayList<Ads> findAll(AdsFilter filter, Paging paging);
	
	/***
	 * Get One Ads
	 * @param id
	 * @return
	 */
	Ads findOne(int id);
	
	/***
	 * Remove Ads by id
	 * @param id
	 * @return
	 */
	boolean remove(int id);
	
	
	/***
	 * Save Ads
	 * @param ads
	 * @return
	 */
	boolean save(Ads ads);
	
	/***
	 * Update Ads by id
	 * @param ads
	 * @return
	 */
	boolean update(Ads ads);
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	boolean toggleStatus(int id);
	
}
