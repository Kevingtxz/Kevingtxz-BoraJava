package com.kevin.bora.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.bora.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Transactional(readOnly=true)
	User findByEmail(String email);
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM User obj INNER JOIN obj.city city WHERE obj.nickName LIKE %:nickName% AND city = :cityId")
	Page<User> findDistinctByNickNameAndCityId(@Param("nickName") String nickName, @Param("cityId") Integer cityId, Pageable pageRequest);
}