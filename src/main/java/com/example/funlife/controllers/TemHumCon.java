package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.funlife.models.TemHum;
import com.example.funlife.services.TemHumService;

@RestController
@RequestMapping("/api/tem-hum")
@CrossOrigin("*")
public class TemHumCon {
	@Autowired
	private TemHumService temHumService;
	
	@GetMapping("/getfinaltemhum")
	public List<TemHum> getFinal(){
		return temHumService.getFinal();
	}
	
	@GetMapping("/getalltemhum")
	public List<TemHum> getALL(){
		return temHumService.getAll();
	}
}
