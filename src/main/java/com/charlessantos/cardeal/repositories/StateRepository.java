package com.charlessantos.cardeal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlessantos.cardeal.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
