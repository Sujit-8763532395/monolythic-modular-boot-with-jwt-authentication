package com.aashdit.wcd.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.user.model.UserLocation;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

	@Query("FROM UserLocation WHERE district.districtId=:locationId AND user.id=:id") 
	UserLocation getDistrictLevelUser(@Param("locationId")Long locationId, @Param("id")Long id); 

	@Query("FROM UserLocation WHERE subdivision.subdivisionId=:locationId AND user.id=:id") 
	UserLocation getSubdivisionLevelUser(@Param("locationId")Long locationId, @Param("id")Long id); 

	@Query("FROM UserLocation WHERE block.blockId=:locationId AND user.id=:id") 
	UserLocation getBlockLevelUser(@Param("locationId")Long locationId, @Param("id")Long id);   
	
}
	