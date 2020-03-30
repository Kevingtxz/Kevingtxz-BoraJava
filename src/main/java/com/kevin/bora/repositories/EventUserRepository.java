package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.EventUser;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Integer>{
}
