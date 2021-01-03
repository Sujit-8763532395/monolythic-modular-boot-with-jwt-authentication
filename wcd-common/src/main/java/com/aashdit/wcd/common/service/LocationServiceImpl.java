package com.aashdit.wcd.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.model.Block;
import com.aashdit.wcd.common.model.District;
import com.aashdit.wcd.common.model.Municipality;
import com.aashdit.wcd.common.model.Panchayat;
import com.aashdit.wcd.common.model.Subdivision;
import com.aashdit.wcd.common.model.Village;
import com.aashdit.wcd.common.repository.BlockRepository;
import com.aashdit.wcd.common.repository.DistrictRepository;
import com.aashdit.wcd.common.repository.MunicipalityRepository;
import com.aashdit.wcd.common.repository.PanchayatRepository;
import com.aashdit.wcd.common.repository.SubdivisionRepository;
import com.aashdit.wcd.common.repository.VillageRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
	
	@Autowired
	private DistrictRepository districtRepository; 
	
	@Autowired
	private SubdivisionRepository subdivisionRepository; 
	
	@Autowired
	private BlockRepository blockRepository; 
	
	@Autowired
	private MunicipalityRepository municipalityRepository; 
	
	@Autowired
	private PanchayatRepository panchayatRepository; 
	
	@Autowired
	private VillageRepository villageRepository; 

	@Override
	public List<District> findAllActiveDistrict() {
		return districtRepository.findAllActiveDistrict(); 
	}

	@Override
	public List<Subdivision> findAllActiveSubdivisionByDistrictId(Long districtId) {
		return subdivisionRepository.findAllActiveSubdivisionByDistrictId(districtId); 
	}

	@Override
	public List<Block> findAllActiveBlockBySubdivisionId(Long subdivisionId) {
		return blockRepository.findAllActiveBlockBySubdivisionId(subdivisionId); 
	}

	@Override
	public List<Block> findAllActiveBlockByDistrictId(Long districtId) {
		return blockRepository.findAllActiveBlockByDistrictId(districtId); 
	}

	@Override
	public List<Municipality> findAllActiveMunicipalityByDistrictId(Long districtId) {
		return municipalityRepository.findAllActiveMunicipalityByDistrictId(districtId);  
	}

	@Override
	public List<Panchayat> findAllActivePanchayatByBlockId(Long blockId) {
		return panchayatRepository.findAllActivePanchayatByBlockId(blockId);  
	}

	@Override
	public List<Village> findAllActiveVillageByPanchayatId(Long panchayatId) {
		return villageRepository.findAllActiveVillageByPanchayatId(panchayatId); 
	}
	
}
	