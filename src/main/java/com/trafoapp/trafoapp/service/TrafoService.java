package com.trafoapp.trafoapp.service;

import java.util.List;

import com.trafoapp.trafoapp.entity.Battery;
import com.trafoapp.trafoapp.entity.Trafo;



public interface TrafoService {

public List<Trafo> findAll();
	
	public Trafo findById(int theId);
	
	public void save(Trafo theTrafo);
	
	public void deleteById(int theId);
	
	public void saveTrafoAndBattery();
	
	public List<Trafo> findByPower(int power);
	
	public List<Trafo> findByType(String type);
	
	public List<Trafo> findByBattery(String battery);
	
	public List<Trafo> findByTrafoDisconnector(String disconnector);
	
	public List<Trafo> findByDisconnector(String disconnector);

}
