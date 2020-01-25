package com.charlessantos.cardeal.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charlessantos.cardeal.domain.Vehicle;
import com.charlessantos.cardeal.domain.VehicleModel;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Vehicle obj INNER JOIN obj.model WHERE obj.model = :modelId")
	Page<Vehicle> search(@Param("modelId") VehicleModel model, Pageable pageRequest);
}
