package com.aashdit.wcd.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.common.model.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {

	@Query("FROM Block WHERE subdivision.subdivisionId=:subdivisionId AND isActive=true") 
	List<Block> findAllActiveBlockBySubdivisionId(@Param("subdivisionId")Long subdivisionId);

	@Query("FROM Block WHERE district.districtId=:districtId AND isActive=true") 
	List<Block> findAllActiveBlockByDistrictId(@Param("districtId")Long districtId);
	
}
	