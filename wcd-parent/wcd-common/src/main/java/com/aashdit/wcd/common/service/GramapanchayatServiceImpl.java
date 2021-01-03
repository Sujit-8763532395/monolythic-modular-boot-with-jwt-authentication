package com.aashdit.wcd.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.PanchayatRepository;

@Service
public class GramapanchayatServiceImpl implements GramapanchayatService {
	
	private static final Logger logger = LoggerFactory.getLogger(GramapanchayatServiceImpl.class);
	
	@Autowired
	private PanchayatRepository panchayatRepository;  
	
	
	
}
