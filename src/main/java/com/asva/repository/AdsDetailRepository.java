package com.asva.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.asva.model.ads.AdsDetail;

@Repository
public interface AdsDetailRepository {

	@Select(SQL.SELECT_ALL)
	@Results({
		@Result(property="id", column="id"),
		@Result(property="location", column="location"),
		@Result(property="type", column="type"),
		@Result(property="maxHeight", column="max_height"),
		@Result(property="maxWidth", column="max_width"),
	})
	ArrayList<AdsDetail> findAll();
	
	@Select(SQL.SELECT_ONE)
	@Results({
		@Result(property="id", column="id"),
		@Result(property="location", column="location"),
		@Result(property="type", column="type"),
		@Result(property="maxHeight", column="max_height"),
		@Result(property="maxWidth", column="max_width"),
	})
	AdsDetail findOne(int id);
	
	interface SQL{
		/***
		 * Get all ads detail
		 */
		String SELECT_ALL = ""
				+ "	SELECT "
				+ "		id,"
				+ "		location,"
				+ "		type,"
				+ "		max_width,"
				+ "		max_height"
				+ "	FROM "
				+ "		ads_detail"
				+ "	ORDER BY"
				+ "		id ASC";
		
		/***
		 * Get one ads by id
		 */
		String SELECT_ONE = ""
				+ "	SELECT"
				+ "		id,"
				+ "		location,"
				+ "		type,"
				+ "		max_width,"
				+ "		max_height"
				+ "	FROM"
				+ "		ads_detail"
				+ "	WHERE"
				+ "		id=#{id}";
		
	}
}
