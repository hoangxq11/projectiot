package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.funlife.models.ServoMode;
import com.example.funlife.services.ServoModeService;

@RestController
@CrossOrigin("*")
public class ServoModeCon {
	@Autowired
	private ServoModeService servoModeService;
	
	@GetMapping("/getfinalservomode")
	public List<ServoMode> getFinal(){
		return servoModeService.getFinal();
	}
	
	@PostMapping("/addservomode")
	public ServoMode add(@RequestBody ServoMode servomode) {
		return servoModeService.add(servomode);
	}
}
