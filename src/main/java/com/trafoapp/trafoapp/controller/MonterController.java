package com.trafoapp.trafoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trafoapp.trafoapp.entity.Monter;
import com.trafoapp.trafoapp.entity.Trafo;
import com.trafoapp.trafoapp.entity.Work;
import com.trafoapp.trafoapp.service.MonterService;

@Controller
@RequestMapping("/monters")

public class MonterController {
	
	@Autowired
	private MonterService monterService;

	@GetMapping("/list")
	public String listMonters(Model theModel) {
		
		List<Monter>monters = monterService.findAll();
		
		theModel.addAttribute("monters", monters);
		
		return "/monters/list-monters";
	
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Monter monter = new Monter();
		theModel.addAttribute("monter", monter);
		return "/monters/monter-form";
}
	
	@PostMapping("/save")
	public String saveMonter(@ModelAttribute("monter") Monter theMonter) {
		
		monterService.save(theMonter);
		return "redirect:/monters/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("monterId") int theId, Model theModel ) {
		
		Monter theMonter = monterService.findById(theId);
		theModel.addAttribute("monter", theMonter);
		
		
		return "/monters/monter-form";	
		
	}
	
	@GetMapping("/delete")
	public String deleteMonter(@RequestParam("monterId") int theId) {
		
	    monterService.deleteById(theId);
	    return "redirect:/monters/list";
		
	}
	@GetMapping("/showFormForSearch")
	  public String showFormForSearch() {		
		return	"/monters/monter-form-for-search";
		}
	
	
	@GetMapping("/search")
	  public String searchMonter(@RequestParam("id") Integer id, Model theModel) {
		if(id==null) {
			id=0;
		}
		Monter theMonter = monterService.findById(id);
		if(theMonter!=null) {
		theModel.addAttribute("monter", theMonter);
		return	"/monters/monter-search";
		}else return "/monters/monter-form-for-search";
		
		}
	
	
}