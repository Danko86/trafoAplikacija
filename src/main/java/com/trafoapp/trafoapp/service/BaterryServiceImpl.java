package com.trafoapp.trafoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trafoapp.trafoapp.dao.BatteryRepository;
import com.trafoapp.trafoapp.entity.Battery;



@Service
public class BaterryServiceImpl implements BatteryService {

	@Autowired
	private BatteryRepository batteryRepository;

	@Override
	public Battery findById(int theId) {
Optional<Battery> result = batteryRepository.findById(theId);
		
		Battery theBattery = null;
		
		if (result.isPresent()) {
			theBattery = result.get();
		}
		else {
			
			throw new RuntimeException("Nije nadjena baterija sa tim id-om - " + theId);
		}
		
		return theBattery;
	}
	

	@Override
	public void save(Battery theBaterry) {
	
	batteryRepository.save(theBaterry);

		}
		

	@Override
	public void deleteById(int theId) {
	    batteryRepository.deleteById(theId);
		
	}

	@Override
	public List<Battery> findAll() {
		
		return batteryRepository.findAll();
	}


	@Override
	public void delete(Battery battery) {
		batteryRepository.delete(battery);
		
		
	}


	@Override
	public Battery firstCheckIfAlreadyExists(Battery theBattery) {
		List<Battery> batteries = batteryRepository.findAll();
		for (Battery battery : batteries) {
			if(battery.equals(theBattery)){
				theBattery.setId(battery.getId());
				break;		
			
		}}
		return theBattery;
		
	}
	
	
		
	

}
