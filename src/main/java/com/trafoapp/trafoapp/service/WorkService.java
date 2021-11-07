package com.trafoapp.trafoapp.service;

import java.util.Collection;
import java.util.List;

import com.trafoapp.trafoapp.entity.Work;

public interface WorkService {

	public List<Work>findAll();

	public Work findById(int id);
	
	public void save(Work theWork);
	
	public void deleteById(int theId);
	
	public List<Work> findByTrafoNumber(int id);
	
	public List<Work> findByMainMonter(int number);
	
	public List<Work> findByMonter(String number);
}
