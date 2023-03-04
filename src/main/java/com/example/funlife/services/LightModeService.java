package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.LightMode;
import com.example.funlife.respositorys.LightModeRep;

@Service
public class LightModeService {
	@Autowired
	LightModeRep lightModeRep;
	
	public List<LightMode> getFinal() {
		return lightModeRep.findFinal();
	}
	
	public LightMode add(LightMode lightmode) {
		return lightModeRep.save(lightmode);
	}
}
