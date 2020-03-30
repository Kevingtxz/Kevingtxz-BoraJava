package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
}
