package com.aashdit.wcd.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.DistrictRepository;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	private static final Logger logger = LoggerFactory.getLogger(DistrictServiceImpl.class);
	
	@Autowired
	private DistrictRepository districtRepository; 
	
	
	
}
	