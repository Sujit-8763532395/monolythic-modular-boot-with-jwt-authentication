package com.aashdit.wcd.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {
	
	private static final Logger logger = LoggerFactory.getLogger(BlockServiceImpl.class);
	
	@Autowired
	private BlockRepository blockRepository; 
	
	
	
}
	