package com.trafoapp.trafoapp.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafoapp.trafoapp.entity.Work;


public interface WorkRepository extends JpaRepository<Work, Integer> {

	@Query(
			  value = "SELECT * FROM WORK w WHERE w.trafo_number =?1 ", 
			  nativeQuery = true)
	public List<Work> findByTrafoNumber(int id);
	
	
	@Query(
			  value = "SELECT * FROM WORK w  WHERE w.monter_personal_number =?1 ", 
			  nativeQuery = true)
	public List<Work> findByMainMonter(int number);
	
	@Query(
			  value = "SELECT * FROM WORK w  WHERE w.other_monters LIKE %:number% ", 
			  nativeQuery = true)
	public List<Work> findByMonter(String number);
}



