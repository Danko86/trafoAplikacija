package com.trafoapp.trafoapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.stereotype.Service;

import com.trafoapp.trafoapp.dao.BatteryRepository;
import com.trafoapp.trafoapp.dao.TrafoRepository;
import com.trafoapp.trafoapp.entity.Battery;
import com.trafoapp.trafoapp.entity.Disconnector;
import com.trafoapp.trafoapp.entity.Trafo;

@Service
public class TrafoServiceImpl implements TrafoService {
	
	private TrafoRepository trafoRepository;
	
	private Battery theBattery;
	private Disconnector theDisconnector;
	
	@Autowired
	private DisconnectorService disconnectorService;
	
	@Autowired
	private BatteryService batteryService;
	
	public TrafoServiceImpl(TrafoRepository theTrafoRepository) {
		trafoRepository = theTrafoRepository;
	}
	

	@Override
	public List<Trafo> findAll() {
		return trafoRepository.findAllByOrderByNumberAsc();  
		
	}

	@Override
	public Trafo findById(int theNumber) {
Optional<Trafo> result = trafoRepository.findById(theNumber);
		
		Trafo theTrafo = null;
		
		if (result.isPresent()) {
			theTrafo = result.get();
			return theTrafo;
		}
		else {
			
			return null;
		}
		
		
	}

	@Override
	public void save(Trafo theTrafo) {
	
	      theBattery = theTrafo.getBattery();
	      theBattery = batteryService.firstCheckIfAlreadyExists(theBattery);
	      theTrafo.setBattery(theBattery);
	      
	      theDisconnector = theTrafo.getDisconnector();
	      theDisconnector = disconnectorService.firstCheckIfAlreadyExists(theDisconnector);
	      theTrafo.setDisconnector(theDisconnector);
	      
		  trafoRepository.save(theTrafo);
		
		}
		
	

	@Override
	public void deleteById(int theNumber) {
		trafoRepository.deleteById(theNumber);
		
	}


	@Override
	public void saveTrafoAndBattery() {
		
		
	}


	@Override
	public List<Trafo> findByPower(int power) {
		List<Trafo>trafos=trafoRepository.findByPower(power);
		return trafos;
	}


	@Override
	public List<Trafo> findByType(String type) {
		List<Trafo>trafos=trafoRepository.findByType(type);
		return trafos;
	}


	@Override
	public List<Trafo> findByBattery(String battery) {
		List<Trafo>trafos=trafoRepository.findByBattery(battery);
		return trafos;
	}


	@Override
	public List<Trafo> findByTrafoDisconnector(String disconnector) {
		List<Trafo>trafos=trafoRepository.findByTrafoDisconnector(disconnector);
		return trafos;
	}


	@Override
	public List<Trafo> findByDisconnector(String disconnector) {
		List<Trafo>trafos=trafoRepository.findByDisconnector(disconnector);
		return trafos;
	}

}
