package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.ManualLight;
import com.example.funlife.respositorys.ManualLightRep;

@Service
public class ManualLightService {
	@Autowired
	ManualLightRep manualLightRep;
	
	public List<ManualLight> getFinal() {
		return manualLightRep.findFinal();
	}
	
	public ManualLight add(ManualLight manuallight) {
		return manualLightRep.save(manuallight);
	}
}
