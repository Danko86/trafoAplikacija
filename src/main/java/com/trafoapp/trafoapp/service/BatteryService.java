package com.trafoapp.trafoapp.service;

import java.util.List;

import com.trafoapp.trafoapp.entity.Battery;

public interface BatteryService {
	
	public List<Battery>findAll();

		public Battery findById(int theId);
		
		public void save(Battery theBaterry);
		
		public void deleteById(int theId);
		
		public void delete(Battery battery);
		
		public Battery firstCheckIfAlreadyExists(Battery battery);
	}

