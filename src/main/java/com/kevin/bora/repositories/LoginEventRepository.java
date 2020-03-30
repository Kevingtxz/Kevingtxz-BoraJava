package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.LoginEvent;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Integer>{
	
}