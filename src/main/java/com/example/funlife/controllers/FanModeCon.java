package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.funlife.models.FanMode;
import com.example.funlife.services.FanModeService;

@RestController
@RequestMapping("/api/fan")
@CrossOrigin("*")
public class FanModeCon {
	@Autowired
	private FanModeService fanModeService;
	
	@GetMapping("/getfinalfanmode")
	public List<FanMode> getFinal(){
		return fanModeService.getFinal();
	}
	
	@PostMapping("/addfanmode")
	public FanMode add(@RequestBody FanMode fanmode) {
		return fanModeService.add(fanmode);
	}
}
