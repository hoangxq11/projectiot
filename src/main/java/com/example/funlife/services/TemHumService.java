package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.TemHum;
import com.example.funlife.respositorys.TemHumRep;

@Service
public class TemHumService {
	@Autowired
	private TemHumRep temHumRep;
	
	public List<TemHum> getAll(){
		return temHumRep.findAll();
	}
	
	public List<TemHum> getFinal() {
		return temHumRep.findFinal();
	}
}
