package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
}
