package com.trafoapp.trafoapp.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trafoapp.trafoapp.dao.MonterRepository;
import com.trafoapp.trafoapp.dao.WorkRepository;
import com.trafoapp.trafoapp.entity.Trafo;
import com.trafoapp.trafoapp.entity.Work;
import com.trafoapp.trafoapp.service.WorkService;

@Controller
@RequestMapping("/works")
public class WorkController {

	@Autowired
	private WorkRepository workRepository;
	
	private MonterRepository monterRepository;
	@Autowired
	private WorkService workService;
	
	@GetMapping("/list")
	public String listWorks(Model theModel) {
		
		List<Work>works = workService.findAll();
		theModel.addAttribute("works", works);
		return "/works/list-works";
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Work work = new Work();
		theModel.addAttribute("work", work);
		return "/works/work-form";
	}
	
	
	@PostMapping("/save")
	public String saveWork(@Valid Work theWork, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/works/work-form";
		}else {
		workService.save(theWork);
		return "redirect:/works/list";
		
	}
	}
		
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("workId") int theId, Model theModel ) {
		
		Work theWork = workService.findById(theId);
		theModel.addAttribute("work", theWork);
		
		
		return "/works/work-form";	
		
	}
	
	
	@GetMapping("/delete")
	public String deleteWork(@RequestParam("workId") int theId) {
		
		Work theWork = workService.findById(theId);
		theWork.setMonter(null);
		theWork.setTrafo(null);
		workService.deleteById(theId);
		return "redirect:/works/list";
		
	}
	
	@GetMapping("/showFormForSearch")
	  public String showFormForSearch() {		
		return	"/works/work-form-for-search";
		}
	
	@GetMapping("/search")
	  public String searchWork(@RequestParam("id") Integer id, Model theModel) {	
		if(id==null) {
			id=0;
		}
	Collection<Work>works=workService.findByTrafoNumber(id);
	theModel.addAttribute("works", works);
		
		return	"/works/work-search";
		}
	
	@GetMapping("/showFormForMultiSearch")
	  public String showFormForMultiSearch() {		
		return	"/works/work-form-for-multi-search";
		}
	
	
	
	@GetMapping("searchByMainMonter")
	  public String searchByMainMonter(@RequestParam("number") Integer number, Model theModel) {	
		 if(number==null) {
				number=0;
			}
			Collection<Work>works=workService.findByMainMonter(number);
			theModel.addAttribute("works", works);
				
				return	"/works/work-multi-search";
				}	
	
	

	@GetMapping("searchByMonter")
	  public String searchByMonter(@RequestParam("number") String number, Model theModel) {	
		 if(number==null) {
				number="";
			}
			Collection<Work>works=workService.findByMonter(number);
			theModel.addAttribute("works", works);
				
				return	"/works/work-multi-search";
				}	
	
}
