package com.aashdit.wcd.common.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aashdit.wcd.common.model.Block;
import com.aashdit.wcd.common.model.District;
import com.aashdit.wcd.common.model.Municipality;
import com.aashdit.wcd.common.model.Panchayat;
import com.aashdit.wcd.common.model.Subdivision;
import com.aashdit.wcd.common.model.Village;
import com.aashdit.wcd.common.service.LocationService;

@RestController
@RequestMapping("/restapi/common/location") 
public class LocationController {
	
	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
	
	@Autowired
	private LocationService locationService;
	
	/**
	 * @author Sujit Mishra
	 * @return districtList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active districts. 
	 */
	@RequestMapping(value = "/getDistrictList", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getDistrictList() throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<District> districtList = locationService.findAllActiveDistrict();   
			if(districtList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (District district : districtList) { 
					jobj = new JSONObject();
					jobj.put("districtId", district.getDistrictId()); 
					jobj.put("districtCode", district.getDistrictCode()); 
					jobj.put("districtName", district.getDistrictName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("districtList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No District Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
	/**
	 * @author Sujit Mishra
	 * @param districtId
	 * @return municipalityList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active municipalities by district id. 
	 */
	@RequestMapping(value = "/getMunicipalityListByDistrict", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getMunicipalityListByDistrict(@RequestParam("districtId")Long districtId) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<Municipality> municipalityList = locationService.findAllActiveMunicipalityByDistrictId(districtId);   
			if(municipalityList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (Municipality municipality : municipalityList) { 
					jobj = new JSONObject();
					jobj.put("municipalityId", municipality.getMunicipalityId()); 
					jobj.put("municipalityCode", municipality.getMunicipalityCode()); 
					jobj.put("municipalityName", municipality.getMunicipalityName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("municipalityList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No Municipality Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
	/**
	 * @author Sujit Mishra
	 * @param districtId
	 * @return subdivisionList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active subdivisions by district id. 
	 */
	@RequestMapping(value = "/getSubdivisionListByDistrict", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getSubdivisionListByDistrict(@RequestParam("districtId")Long districtId) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<Subdivision> subdivisionList = locationService.findAllActiveSubdivisionByDistrictId(districtId);   
			if(subdivisionList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (Subdivision subdivision : subdivisionList) { 
					jobj = new JSONObject();
					jobj.put("subdivisionId", subdivision.getSubdivisionId()); 
					jobj.put("subdivisionCode", subdivision.getSubdivisionCode()); 
					jobj.put("subdivisionName", subdivision.getSubdivisionName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("subdivisionList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No Subdivision Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
	/**
	 * @author Sujit Mishra
	 * @param subdivisionId
	 * @return blockList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active blocks by subdivision id. 
	 */
	@RequestMapping(value = "/getBlockListBySubdivision", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getBlockListBySubdivision(@RequestParam("subdivisionId")Long subdivisionId) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<Block> blockList = locationService.findAllActiveBlockBySubdivisionId(subdivisionId);   
			if(blockList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (Block block : blockList) { 
					jobj = new JSONObject();
					jobj.put("blockId", block.getBlockId()); 
					jobj.put("blockCode", block.getBlockCode()); 
					jobj.put("blockName", block.getBlockName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("blockList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No Block Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
	/**
	 * @author Sujit Mishra
	 * @param districtId
	 * @return blockList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active blocks by district id.
	 */
	@RequestMapping(value = "/getBlockListByDistrict", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getBlockListByDistrict(@RequestParam("districtId")Long districtId) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<Block> blockList = locationService.findAllActiveBlockByDistrictId(districtId);   
			if(blockList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (Block block : blockList) { 
					jobj = new JSONObject();
					jobj.put("blockId", block.getBlockId()); 
					jobj.put("blockCode", block.getBlockCode()); 
					jobj.put("blockName", block.getBlockName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("blockList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No Block Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
	/**
	 * @author Sujit Mishra
	 * @param blockId
	 * @return gramapanchayatList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active gramapanchayats by block id.
	 */
	@RequestMapping(value = "/getGramapanchayatListByBlock", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getGramapanchayatListByBlock(@RequestParam("blockId")Long blockId) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<Panchayat> panchayatList = locationService.findAllActivePanchayatByBlockId(blockId);   
			if(panchayatList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (Panchayat panchayat : panchayatList) { 
					jobj = new JSONObject();
					jobj.put("panchayatId", panchayat.getGpId()); 
					jobj.put("panchayatCode", panchayat.getGpCode()); 
					jobj.put("panchayatName", panchayat.getGpName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("panchayatList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No Gramapanchayat Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
	/**
	 * @author Sujit Mishra
	 * @param panchayatId
	 * @return villageList
	 * @throws JSONException
	 * @date 2020-07-08
	 * @purpose To get all active villages by gramapanchayat id.
	 */
	@RequestMapping(value = "/getVillageListByGramapanchayat", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getVillageListByGramapanchayat(@RequestParam("panchayatId")Long panchayatId) throws JSONException {
		
		JSONObject jsonObject = new JSONObject(); 	
		try {		
			List<Village> villageList = locationService.findAllActiveVillageByPanchayatId(panchayatId);   
			if(villageList.size() > 0) { 
				JSONArray jarr = new JSONArray();
				JSONObject jobj = null;
				for (Village village : villageList) { 
					jobj = new JSONObject();
					jobj.put("villageId", village.getVillageId()); 
					jobj.put("villageCode", village.getVillageCode()); 
					jobj.put("villageName", village.getVillageName()); 
					jarr.put(jobj);
				} 
				jsonObject.put("villageList", jarr); 
				jsonObject.put("flag", "Success"); 
				jsonObject.put("Message", "Success"); 
			}
			else {
				jsonObject.put("Message", "No Village Found");  
				jsonObject.put("flag", "Failure");
			}
		}
		catch(Exception e) {
			jsonObject.put("flag", "Error");
			logger.error("Error Message: "+e.toString());   
		}	
		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 	
	}
	
}
	