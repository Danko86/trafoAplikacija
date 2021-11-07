package com.trafoapp.trafoapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.trafoapp.trafoapp.dao.WorkRepository;
import com.trafoapp.trafoapp.entity.Monter;
import com.trafoapp.trafoapp.entity.Work;

@Service
public class WorkServiceImpl implements WorkService{
	
	private Monter theMonter;
	@Autowired
	WorkRepository workRepository;
	
	@Autowired
	private MonterService monterService;

	@Override
	public List<Work> findAll() {
		return workRepository.findAll();
	}

	@Override
	public Work findById(int id) {
		Optional<Work> result = workRepository.findById(id);

		Work theWork = null;

		if (result.isPresent()) {
			theWork = result.get();
		} else {

			throw new RuntimeException("Nije nadjen rad za tu trafostanicu - " + id);
		}

		return theWork;
	}
	


	@Override
	public void save(Work theWork) {
		theMonter = theWork.getMonter();
		theMonter =  monterService.firstCheckIfAlreadyExists(theMonter);
	      theWork.setMonter(theMonter);
		workRepository.save(theWork);
		
	}

	@Override
	public void deleteById(int id) {
		workRepository.deleteById(id);
		
	}

	@Override
	public List<Work> findByTrafoNumber(int id) {
		List<Work>works=workRepository.findByTrafoNumber(id);
		return works;
	}

	@Override
	public List<Work> findByMainMonter(int number) {
		List<Work>works=workRepository.findByMainMonter(number);
		return works;
	}

	@Override
	public List<Work> findByMonter(String number) {
		List<Work>works=workRepository.findByMonter(number);
		return works;
	}

}
