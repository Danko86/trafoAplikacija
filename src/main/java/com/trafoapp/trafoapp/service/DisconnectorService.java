package com.trafoapp.trafoapp.service;

import java.util.List;

import com.trafoapp.trafoapp.entity.Battery;
import com.trafoapp.trafoapp.entity.Disconnector;

public interface DisconnectorService {

	public List<Disconnector>findAll();

	public Disconnector findById(int theId);
	
	public void save(Disconnector disconnector);
	
	public void deleteById(int theId);
	
	public void delete(Disconnector disconnector);
	
	public Disconnector firstCheckIfAlreadyExists(Disconnector disconnector);
}
