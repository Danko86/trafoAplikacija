package com.trafoapp.trafoapp.service;

import java.util.List;


import com.trafoapp.trafoapp.entity.Monter;


public interface MonterService {

	public List<Monter>findAll();

	public Monter findById(int theId);
	
	public void save(Monter theMonter);
	
	public void deleteById(int theId);
	
	public Monter firstCheckIfAlreadyExists(Monter theMonter);
}
