package com.trafoapp.trafoapp.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trafoapp.trafoapp.entity.Battery;
import com.trafoapp.trafoapp.entity.Trafo;
import com.trafoapp.trafoapp.entity.Work;
import com.trafoapp.trafoapp.service.BatteryService;
import com.trafoapp.trafoapp.service.TrafoService;


@Controller
@RequestMapping("/trafos")
public class TrafoController {

	@Autowired
	private TrafoService trafoService;

	
	@GetMapping("/list")
	public String listTrafos(Model theModel) {
		
		
		List<Trafo> theTrafos = trafoService.findAll();
		
		theModel.addAttribute("trafos", theTrafos);
		
		return "/trafos/list-trafos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		
		Trafo theTrafo = new Trafo();
		
		theModel.addAttribute("trafo", theTrafo);
		
		return "/trafos/trafo-form";
	}
	
	@PostMapping("/save")
	public String saveTrafo(@Valid Trafo theTrafo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/trafos/trafo-form";
		}else {
		trafoService.save(theTrafo);
		return "redirect:/trafos/list";
		}
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("trafoId") int theId, Model theModel ) {
		
		Trafo theTrafo = trafoService.findById(theId);
		theModel.addAttribute("trafo", theTrafo);
		
		
		return "/trafos/trafo-form";	
		
	}
	
	@GetMapping("/delete")
	public String deleteTrafo(@RequestParam("trafoId") int theId) {
		
		Trafo theTrafo = trafoService.findById(theId);
		theTrafo.setBattery(null);
		theTrafo.setDisconnector(null);
		trafoService.deleteById(theId);
		return "redirect:/trafos/list";
		
	}
	
	@GetMapping("/showFormForSearch")
	  public String showFormForSearch() {		
		return	"/trafos/trafo-form-for-search";
		}
	
	@GetMapping("/search")
	  public String searchTrafo(@RequestParam("id")  Integer id, Model theModel) {	
		if(id==null) {
			id=0;
		}
		Trafo theTrafo = trafoService.findById(id);
		if(theTrafo!=null) {
		theModel.addAttribute("trafo", theTrafo);
		
		return	"/trafos/trafo-search";
		} else return "/trafos/trafo-form-for-search";
	}
	

	@GetMapping("/showFormForMultiSearch")
	  public String showFormForMultiSearch() {		
		return	"/trafos/trafo-form-for-multi-search";
		}
	
	
  @GetMapping("/logOut")
  public String logOut() {
	  
	  return "../index";
  }
	
  @GetMapping("searchByPower")
  public String searchByPower(@RequestParam("id") Integer id, Model theModel) {	
	  if(id==null) {
			id=0;
		}
		Collection<Trafo>trafos=trafoService.findByPower(id);
		theModel.addAttribute("trafos", trafos);
			
			return	"/trafos/trafo-multi-search";
			}	
  
  @GetMapping("searchByType")
  public String searchByType(@RequestParam("type") String type, Model theModel) {	
		if(type.isEmpty()) {
			type=" ";
		}
		Collection<Trafo>trafos=trafoService.findByType(type);
		theModel.addAttribute("trafos", trafos);
			
			return	"/trafos/trafo-multi-search";
			}	
  
  @GetMapping("searchByBattery")
  public String searchByBattery(@RequestParam("battery") String battery, Model theModel) {	
		if(battery.isEmpty()) {
			battery=" ";
		}
		Collection<Trafo>trafos=trafoService.findByBattery(battery);
		theModel.addAttribute("trafos", trafos);
			
			return	"/trafos/trafo-multi-search";
			}	
  
  @GetMapping("searchByTrafoDisconnector")
  public String searchByTrafoDisconnector(@RequestParam("disconnector") String disconnector, Model theModel) {	
		if(disconnector.isEmpty()) {
			disconnector=" ";
		}
		Collection<Trafo>trafos=trafoService.findByTrafoDisconnector(disconnector);
		theModel.addAttribute("trafos", trafos);
			
			return	"/trafos/trafo-multi-search";
			}	
	

  @GetMapping("searchByDisconnector")
  public String searchByDisconnector(@RequestParam("disconnector") String disconnector,  Model theModel) {	
		if(disconnector.isEmpty()) {
			disconnector=" ";
		}
		Collection<Trafo>trafos=trafoService.findByDisconnector(disconnector);
		theModel.addAttribute("trafos", trafos);
			
			return	"/trafos/trafo-multi-search";
			}	
	
	
}
