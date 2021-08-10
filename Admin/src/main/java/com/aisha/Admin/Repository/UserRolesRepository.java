package com.aisha.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.aisha.Admin.Entity.User_Roles;



public interface UserRolesRepository extends JpaRepository<User_Roles, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM users_roles e WHERE e.user_id = :user_id and role_id=3",nativeQuery = true)
	int deleteRequestorRoleOnceApproved(@Param("user_id") int user_id);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM users_roles e WHERE e.user_id = :user_id ",nativeQuery = true)
	int deleteAllUserRolesOfGivenId(@Param("user_id") int user_id);

}
