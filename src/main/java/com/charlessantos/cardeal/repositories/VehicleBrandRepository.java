package com.charlessantos.cardeal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlessantos.cardeal.domain.VehicleBrand;

@Repository
public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Integer> {

}
