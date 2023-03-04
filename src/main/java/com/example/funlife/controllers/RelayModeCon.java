package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.funlife.models.RelayMode;
import com.example.funlife.services.RelayModeService;

@RestController
@RequestMapping("/api/relay")
@CrossOrigin("*")
public class RelayModeCon {
	@Autowired
	private RelayModeService relayModeService;
	
	@GetMapping("/getfinalrelaymode")
	public List<RelayMode> getFinal(){
		return relayModeService.getFinal();
	}
	
	@PostMapping("/addrelaymode")
	public RelayMode add(@RequestBody RelayMode relaymode) {
		return relayModeService.add(relaymode);
	}
}
