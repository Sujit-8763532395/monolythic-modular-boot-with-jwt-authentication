package com.aashdit.wcd.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashdit.wcd.user.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
	