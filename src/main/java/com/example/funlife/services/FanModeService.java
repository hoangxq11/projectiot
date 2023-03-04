package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.FanMode;
import com.example.funlife.respositorys.FanModeRep;

@Service
public class FanModeService {
	@Autowired
	FanModeRep fanModeRep;
	
	public List<FanMode> getFinal() {
		return fanModeRep.findFinal();
	}
	
	public FanMode add(FanMode fanmode) {
		return fanModeRep.save(fanmode);
	}
}
