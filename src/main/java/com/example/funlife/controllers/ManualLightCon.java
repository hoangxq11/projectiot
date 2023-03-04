package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.funlife.models.ManualLight;
import com.example.funlife.services.ManualLightService;

@RestController
@RequestMapping("/api/light")
@CrossOrigin("*")
public class ManualLightCon {
	@Autowired
	private ManualLightService manualLightService;
	
	@GetMapping("/getfinalmanuallight")
	public List<ManualLight> getFinal(){
		return manualLightService.getFinal();
	}
	
	@PostMapping("/addmanuallight")
	public ManualLight add(@RequestBody ManualLight manuallight) {
		return manualLightService.add(manuallight);
	}
}
