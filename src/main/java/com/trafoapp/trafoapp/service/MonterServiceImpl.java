package com.trafoapp.trafoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trafoapp.trafoapp.dao.MonterRepository;
import com.trafoapp.trafoapp.entity.Battery;
import com.trafoapp.trafoapp.entity.Monter;

@Service
public class MonterServiceImpl implements MonterService{

	@Autowired
	private MonterRepository monterRepository;
	
	@Override
	public List<Monter> findAll() {
		
		return monterRepository.findAll();
	}

	@Override
	public Monter findById(int theId) {

		Optional<Monter> result = monterRepository.findById(theId);

		Monter theMonter = null;

		if (result.isPresent()) {
			theMonter = result.get();
		} else {

			return null;
		}

		return theMonter;
	}

	@Override
	public void save(Monter theMonter) {
	
		monterRepository.save(theMonter);
		
	}

	@Override
	public void deleteById(int theId) {
		
		monterRepository.deleteById(theId);
		
	}

	@Override
	public Monter firstCheckIfAlreadyExists(Monter theMonter) {
		List<Monter> monters = monterRepository.findAll();
		for (Monter monter : monters) {
			if(monter.equals(theMonter)) {
				theMonter.setPersonalNumber(monter.getPersonalNumber());
				break;
			}
		}
		return theMonter;
	}
	
//	List<Battery> batteries = batteryRepository.findAll();
//	for (Battery battery : batteries) {
//		if(battery.equals(theBattery)){
//			theBattery.setId(battery.getId());
//			break;		
//		
//	}}
//	return theBattery;

}
