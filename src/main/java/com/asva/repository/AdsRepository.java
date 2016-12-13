package com.asva.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.asva.model.ads.Ads;
import com.asva.util.filter.AdsFilter;
import com.asva.util.paging.Paging;

@Repository
public interface AdsRepository {
	
	/***
	 * Save Ads
	 * @param ads
	 * @return
	 */
	@Insert(SQL.INSERT)
	boolean save(Ads ads);
		
	/***
	 * Update Ads
	 * @param ads
	 * @return
	 */
	@Update(SQL.UPDATE)
	boolean update(Ads ads);
	
	
	/***
	 * Remove Ads
	 * @param id
	 * @return
	 */
	@Delete(SQL.DELETE)
	boolean remove(int id);
	
	
	/***
	 * Get All Ads By Filter
	 * @param filter
	 * @param paging
	 * @return
	 */
	@Select(SQL.SELECT_ALL)
	@Results({
		@Result(property="name", column="name"),
		@Result(property="owner", column="owner"),
		@Result(property="image", column="image"),
		@Result(property="link", column="link"),
		@Result(property="height", column="height"),
		@Result(property="width", column="width"),
		@Result(property="status", column="status"),
		@Result(property="adsDetail.id", column="aid"),
		@Result(property="adsDetail.location", column="location"),
		@Result(property="adsDetail.type", column="type"),
		@Result(property="adsDetail.maxWidth", column="max_width"),
		@Result(property="adsDetail.maxHeight", column="max_height")
	})
	ArrayList<Ads> findAll(@Param("filter") AdsFilter filter, @Param("paging") Paging paging);
	
	
	/***
	 * Get One Ads
	 * @param id
	 * @return
	 */
	@Select(SQL.SELECT_ONE)
	@Results({
		@Result(property="name", column="name"),
		@Result(property="owner", column="owner"),
		@Result(property="image", column="image"),
		@Result(property="link", column="link"),
		@Result(property="height", column="height"),
		@Result(property="width", column="width"),
		@Result(property="status", column="status"),
		@Result(property="adsDetail.id", column="aid"),
		@Result(property="adsDetail.location", column="location"),
		@Result(property="adsDetail.type", column="type"),
		@Result(property="adsDetail.maxWidth", column="max_width"),
		@Result(property="adsDetail.maxHeight", column="max_height")
	})
	Ads findOne(int id);
	
	
	/***
	 * Count Ads By Filter
	 * @param filter
	 * @return
	 */
	@Select(SQL.COUNT)
	Long count(AdsFilter filter);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@Update(SQL.TOGGLE_STATUS)
	boolean toggleStatus(int id);
	
	/***
	 * SQL Factory
	 * 
	 * @author Rath Phearun
	 */
	interface SQL {
		
		/***
		 * Insert Query
		 */
		String INSERT = ""
				+ "	INSERT INTO ads "
				+ "	("
				+ "		name,"
				+ "		owner,"
				+ "		image,"
				+ "		link,"
				+ "		height,"
				+ "		width,"
				+ "		status,"
				+ "		ads_detail_id	"
				+ "	)"
				+ "	VALUES"
				+ "	("
				+ "		#{name},"
				+ "		#{owner}, "
				+ "		#{image},"
				+ "		#{link},"
				+ "		#{height},"
				+ "		#{width},"
				+ "		#{status},"
				+ "		#{adsDetail.id}"
				+ "	)";
		
		
		/***
		 * Delete Query
		 */
		String DELETE = ""
				+ "	DELETE"
				+ "	FROM"
				+ "		ads"
				+ "	WHERE"
				+ "		id = #{id}";
		
		
		/***
		 * Update Query
		 */
		String UPDATE = ""
				+ "	UPDATE ads"
				+ "	SET "
				+ "		name = #{name},"
				+ "		owner = #{owner},"
				+ "		image = #{image},"
				+ "		link = #{link},"
				+ "		height = #{height},"
				+ "		width = #{width},"
				+ "		status = #{status},"
				+ "		ads_detail_id = #{adsDetail.id}"
				+ "	WHERE"
				+ "		id = #{id}";
		
		/***
		 * Select One Query
		 */
		String SELECT_ONE = ""
				+ "	SELECT"
				+ "		A.id,"
				+ "		A.name,"
				+ "		A.owner,"
				+ "		A.image,"
				+ "		A.link,"
				+ "		A.height,"
				+ "		A.width,"
				+ "		A.status,"
				+ "		AD.id AS aid,"
				+ "		AD.location,"
				+ "		AD.type, "
				+ "		AD.max_height,"
				+ "		AD.max_width"
				+ "	FROM	"
				+ "		ads A"
				+ "	LEFT JOIN ads_detail AD ON A.ads_detail_id = AD.id"
				+ "	WHERE"
				+ "		A.id = #{id}";
		
		/***
		 * Select All Query
		 */
		String SELECT_ALL = ""
				+ "	SELECT"
				+ "		A.id,"
				+ "		A.name,"
				+ "		A.owner,"
				+ "		A.image,"
				+ "		A.link,"
				+ "		A.height,"
				+ "		A.width,"
				+ "		A.status,"
				+ "		AD.id AS aid,"
				+ "		AD.location,"
				+ "		AD.type, "
				+ "		AD.max_height,"
				+ "		AD.max_width"
				+ "	FROM	"
				+ "		ads A"
				+ "	LEFT JOIN ads_detail AD ON A .ads_detail_id = ad.id"
				
				+ "	WHERE"
				+ "			LOWER (A.owner) LIKE '%' || LOWER (#{filter.byOwner}) || '%'"
				+ "		AND "
				+ "			LOWER (AD.location) LIKE '%' || LOWER (#{filter.byLocation}) || '%'"
				+ "		AND "
				+ "			A.status LIKE '%' || #{filter.status} || '%' "
				+ "	ORDER BY"
				+ "		A.id DESC"
				
				+ "	LIMIT #{paging.limit} OFFSET #{paging.offset}";
		
		/***
		 * Count Query
		 */
		String COUNT = ""
				+ "	SELECT "
				+ "		COUNT(*)"
				+ "	FROM"
				+ "		ads A"
				+ "	LEFT JOIN ads_detail AD ON A .ads_detail_id = ad.id"
				+ "	WHERE"
				+ "			LOWER (A.owner) LIKE '%' || LOWER (#{byOwner}) || '%'"
				+ "		AND "
				+ "			LOWER (AD.location) LIKE '%' || LOWER (#{byLocation}) || '%'"
				+ "		AND "
				+ "			A.status LIKE '%' || #{status} || '%' ";
		
		String TOGGLE_STATUS =""
				+ "	UPDATE "
				+ "		ads "
				+ "	SET "
				+ "		status = "
				+ "		("
				+ "			CASE status "
				+ "				WHEN '1' "
				+ "					THEN '0' "
				+ "					ELSE '1' "
				+ "			END"
				+ "		) "
				+ "	WHERE "
				+ "		id = #{id}";
		
	}

}
