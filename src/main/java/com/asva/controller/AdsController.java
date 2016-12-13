package com.asva.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asva.model.ads.Ads;
import com.asva.service.ads.AdsService;
import com.asva.util.filter.AdsFilter;
import com.asva.util.paging.Paging;
import com.asva.util.response.Response;
import com.asva.util.response.ResponseCode;
import com.asva.util.response.ResponseList;
import com.asva.util.response.ResponseRecord;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/***
 * @author PHEARUN
 */
@RestController
@RequestMapping("/api/ads")
public class AdsController {

	@Autowired
	private AdsService adsService;

	/***
	 * Get all ads with filtering and paging
	 * 
	 * @param filter
	 * @param paging
	 * @return
	 */
	@ApiImplicitParams({
			// Filter Param
			@ApiImplicitParam(name = "status", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by ads's status"),
			@ApiImplicitParam(name = "byOwner", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by ads's owner"),
			@ApiImplicitParam(name = "byLocation", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by ads's location"),

			// Paging Param
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "1", value = "Page"),
			@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "10", value = "Limit") 
	})
	@ApiOperation("Get All Ads")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseList<Ads> findAll(@ApiIgnore AdsFilter filter, @ApiIgnore Paging paging) {
		ResponseList<Ads> response = new ResponseList<>();

		ArrayList<Ads> adss = adsService.findAll(filter, paging);

		if (adss.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);

		response.setData(adss);
		response.setPaging(paging);
		return response;
	}

	/***
	 * Get one ads
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("Get One Ads")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseRecord<Ads> findOne(@PathVariable("id") int id) {

		ResponseRecord<Ads> response = new ResponseRecord<>();
		Ads ads = adsService.findOne(id);
		if (ads == null)
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);

		response.setData(ads);

		return response;
	}

	/***
	 * Save ads
	 * 
	 * @param ads
	 * @return
	 */
	@ApiOperation("Save Ads")
	@RequestMapping(method = RequestMethod.POST)
	public Response saveAds(@RequestBody Ads ads) {
		Response response = new Response();

		if (adsService.save(ads))
			response.setCode(ResponseCode.INSERT_SUCCESS);

		return response;
	}

	/***
	 * Remove ads by id
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("Remove Ads")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response removeAds(@PathVariable("id") int id) {
		Response response = new Response();

		if (adsService.remove(id))
			response.setCode(ResponseCode.DELETE_SUCCESS);

		return response;
	}

	/***
	 * Update ads by id
	 * 
	 * @param ads
	 * @return
	 */
	@ApiOperation("Update Ads")
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateAds(@RequestBody Ads ads) {
		Response response = new Response();

		if (adsService.update(ads))
			response.setCode(ResponseCode.UPDATE_SUCCESS);

		return response;
	}
	
	@ApiOperation("Toggle Ads Status")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Response toggleStatus(@PathVariable("id") int id) {
		Response response = new Response();
		System.out.println("id" + id);
		if (adsService.toggleStatus(id))
			response.setCode(ResponseCode.UPDATE_SUCCESS);

		return response;
	}


}
