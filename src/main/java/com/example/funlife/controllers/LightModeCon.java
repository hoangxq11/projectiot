package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.funlife.models.LightMode;
import com.example.funlife.services.LightModeService;

@RestController
@RequestMapping("/api/light")
@CrossOrigin("*")
public class LightModeCon {
	@Autowired
	private LightModeService lightModeService;
	
	@GetMapping("/getfinallightmode")
	public List<LightMode> getFinal(){
		return lightModeService.getFinal();
	}
	
	@PostMapping("/addlightmode")
	public LightMode add(@RequestBody LightMode lightmode) {
		return lightModeService.add(lightmode);
	}
}
