package com.aashdit.wcd.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.common.model.Village;

public interface VillageRepository extends JpaRepository<Village, Long> {

	@Query("FROM Village WHERE panchayat.gpId=:panchayatId AND isActive=true") 
	List<Village> findAllActiveVillageByPanchayatId(@Param("panchayatId")Long panchayatId);  
	
}
	