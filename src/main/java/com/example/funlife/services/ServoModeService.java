package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.ServoMode;
import com.example.funlife.respositorys.ServoModeRep;

@Service
public class ServoModeService {
	@Autowired
	ServoModeRep servoModeRep;
	
	public List<ServoMode> getFinal() {
		return servoModeRep.findFinal();
	}
	
	public ServoMode add(ServoMode servomode) {
		return servoModeRep.save(servomode);
	}
}
