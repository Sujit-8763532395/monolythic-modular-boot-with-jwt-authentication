package com.aashdit.wcd.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.common.model.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {

	@Query("FROM Municipality WHERE district.districtId=:districtId AND isActive=true") 
	List<Municipality> findAllActiveMunicipalityByDistrictId(@Param("districtId")Long districtId); 
	
}
	