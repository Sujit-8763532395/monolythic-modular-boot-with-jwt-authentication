package com.aashdit.wcd.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.common.model.Subdivision;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

	@Query("FROM Subdivision WHERE district.districtId=:districtId AND isActive=true") 
	List<Subdivision> findAllActiveSubdivisionByDistrictId(@Param("districtId")Long districtId); 
	
}
	