package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.Gas;
import com.example.funlife.respositorys.GasRep;

@Service
public class GasService {
	@Autowired
	private GasRep gasRep;
	
	public List<Gas> getAll(){
		return gasRep.findAll();
	}
	
	public List<Gas> getFinal() {
		return gasRep.findFinal();
	}
}
