package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.MPEvent;

@Repository
public interface MPEventRepository extends JpaRepository<MPEvent, Integer>{
	
}