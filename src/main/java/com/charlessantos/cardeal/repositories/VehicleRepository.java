package com.charlessantos.cardeal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlessantos.cardeal.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
