package com.aashdit.wcd.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.MunicipalityRepository;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {
	
	private static final Logger logger = LoggerFactory.getLogger(MunicipalityServiceImpl.class);
	
	@Autowired
	private MunicipalityRepository municipalityRepository; 
	
	
	
}
	