package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Integer>{
}
