package com.aashdit.wcd.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.common.model.Panchayat;

public interface PanchayatRepository extends JpaRepository<Panchayat, Long> {

	@Query("FROM Panchayat WHERE block.blockId=:blockId AND isActive=true") 
	List<Panchayat> findAllActivePanchayatByBlockId(@Param("blockId")Long blockId); 
	
}
	