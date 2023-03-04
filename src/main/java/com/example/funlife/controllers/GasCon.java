package com.example.funlife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.funlife.models.Gas;
import com.example.funlife.services.GasService;

@RestController
@RequestMapping("/api/gas")
@CrossOrigin("*")
public class GasCon {
	@Autowired
	private GasService gasService;
	
	@GetMapping("/getfinalgas")
	public List<Gas> getFinal(){
		return gasService.getFinal();
	}
	
	@GetMapping("/getallgas")
	public List<Gas> getALL(){
		return gasService.getAll();
	}
}
