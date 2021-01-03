package com.aashdit.wcd.common.service;

import java.util.List;

import com.aashdit.wcd.common.model.Block;
import com.aashdit.wcd.common.model.District;
import com.aashdit.wcd.common.model.Municipality;
import com.aashdit.wcd.common.model.Panchayat;
import com.aashdit.wcd.common.model.Subdivision;
import com.aashdit.wcd.common.model.Village;

public interface LocationService {

	List<District> findAllActiveDistrict();

	List<Subdivision> findAllActiveSubdivisionByDistrictId(Long districtId);

	List<Block> findAllActiveBlockBySubdivisionId(Long subdivisionId);

	List<Block> findAllActiveBlockByDistrictId(Long districtId);

	List<Municipality> findAllActiveMunicipalityByDistrictId(Long districtId);

	List<Panchayat> findAllActivePanchayatByBlockId(Long blockId);

	List<Village> findAllActiveVillageByPanchayatId(Long panchayatId);       
	
}
	