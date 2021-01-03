package com.aashdit.wcd.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.VillageRepository;

@Service
public class VillageServiceImpl implements VillageService {
	
	private static final Logger logger = LoggerFactory.getLogger(VillageServiceImpl.class);
	
	@Autowired
	private VillageRepository villageRepository; 
	
	
	
}
	