package com.charlessantos.cardeal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlessantos.cardeal.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
