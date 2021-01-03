package com.aashdit.wcd.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.SubdivisionRepository;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {
	
	private static final Logger logger = LoggerFactory.getLogger(SubdivisionServiceImpl.class);
	
	@Autowired
	private SubdivisionRepository subdivisionRepository; 
	
	
	
}
	