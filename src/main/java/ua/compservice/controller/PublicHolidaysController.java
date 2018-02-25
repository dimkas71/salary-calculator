package ua.compservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.compservice.model.PublicHolidays;
import ua.compservice.service.PublicHolidaysService;

@Controller
public class PublicHolidaysController {
	
	private final PublicHolidaysService service;
	
	@Autowired
	public PublicHolidaysController(PublicHolidaysService service) {
		this.service = service;
	}

	@GetMapping("/holidays")
	public String holidays(Model model) {
		
		List<PublicHolidays> holidays = service.findAll();
		model.addAttribute("holidays", holidays);
		
		return "public-holidays/list";
	}
	
	@GetMapping("/api/holidays")
	@ResponseBody
	public List<PublicHolidays> apiHolidays() {
		return service.findAll();
	}
	

}
