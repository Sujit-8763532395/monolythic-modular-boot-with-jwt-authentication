package com.aashdit.wcd.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.user.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	@Query("FROM UserRole WHERE user.id=:userId AND is_primary=true") 
	UserRole getPrimaryRoleByUserId(@Param("userId")Long userId); 

}
	