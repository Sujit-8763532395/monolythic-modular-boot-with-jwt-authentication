package com.aashdit.wcd.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aashdit.wcd.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("FROM User WHERE userName=:username")
	User findByUserName(@Param("username") String username);

	@Query("FROM User WHERE isEnabled=true AND isConfirm=false")
	List<User> getLoggedInUsers();

	@Query(value="SELECT * FROM t_um_user AS u JOIN t_um_user_role AS ur WHERE u.user_id=ur.user_id AND ur.role_id=:id AND isEnabled=true", nativeQuery = true) 
	List<User> findExistingUserByRole(@Param("id")Long id);   

}
	