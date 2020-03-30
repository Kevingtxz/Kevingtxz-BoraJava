package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.MPUser;

@Repository
public interface MPUserRepository extends JpaRepository<MPUser, Integer>{
}
