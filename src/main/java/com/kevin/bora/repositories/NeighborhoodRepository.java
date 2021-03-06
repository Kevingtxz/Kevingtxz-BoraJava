package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.Neighborhood;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Integer>{
}
