package com.aashdit.wcd.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aashdit.wcd.common.model.District;

public interface DistrictRepository extends JpaRepository<District, Long> {

	@Query("FROM District WHERE isActive=true")
	List<District> findAllActiveDistrict();
	
}
	