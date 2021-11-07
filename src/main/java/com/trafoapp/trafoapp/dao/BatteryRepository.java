package com.trafoapp.trafoapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafoapp.trafoapp.entity.Battery;

public interface BatteryRepository extends JpaRepository<Battery, Integer> {

	boolean existsByTypeAndQuantityAndPower(String type, int quantiy, int power);
	boolean existsById(int id);
}
