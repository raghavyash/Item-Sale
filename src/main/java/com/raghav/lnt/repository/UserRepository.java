package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query("select c from UserEntity c where c.email = :email and c.password=:password")
    UserEntity checkLogin(@Param("email") String email, @Param("password") String password);
	@Query("select c from UserEntity c where c.email = :email")
    UserEntity findByUsername(@Param("email") String email);

}
