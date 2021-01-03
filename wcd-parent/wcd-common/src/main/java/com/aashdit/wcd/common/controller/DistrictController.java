package com.aashdit.wcd.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aashdit.wcd.common.service.DistrictService;

@RestController
@RequestMapping("/restapi/common") 
public class DistrictController {
	
	private static final Logger logger = LoggerFactory.getLogger(DistrictController.class);
	
	@Autowired
	private DistrictService districtService; 
	
	
	
}
	