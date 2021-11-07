package com.trafoapp.trafoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trafoapp.trafoapp.dao.DisconnectorRepository;
import com.trafoapp.trafoapp.entity.Battery;
import com.trafoapp.trafoapp.entity.Disconnector;


@Service
public class DisconnectorServiceImpl  implements DisconnectorService{

	@Autowired
	private DisconnectorRepository disconnectorRepository;
	
	@Override
	public List<Disconnector> findAll() {
	
		return disconnectorRepository.findAll();
	}

	@Override
	public Disconnector findById(int theId) {
		
  Optional<Disconnector> result = disconnectorRepository.findById(theId);
		
		Disconnector theDisconnector = null;
		
		if (result.isPresent()) {
			theDisconnector = result.get();
		}
		else {
			
			throw new RuntimeException("Nije nadjena rastavljac sa brojem - " + theId);
		}
		
		return theDisconnector;
	}

	@Override
	public void save(Disconnector disconnector) {
		disconnectorRepository.save(disconnector);
		
	}

	@Override
	public void deleteById(int theId) {
		disconnectorRepository.deleteById(theId);
		
	}

	@Override
	public void delete(Disconnector disconnector) {
		disconnectorRepository.delete(disconnector);
		
	}

	@Override
	public Disconnector firstCheckIfAlreadyExists(Disconnector theDisconnector) {
		List<Disconnector> disconnectors = disconnectorRepository.findAll();
		for (Disconnector disconnector : disconnectors) {
			if(disconnector.equals(theDisconnector)){
				theDisconnector.setId(disconnector.getId());
				break;		
			
		}}
		return theDisconnector;
		
	}

}
