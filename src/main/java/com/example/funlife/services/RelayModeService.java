package com.example.funlife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funlife.models.RelayMode;
import com.example.funlife.respositorys.RelayModeRep;

@Service
public class RelayModeService {
	@Autowired
	RelayModeRep relayModeRep;
	
	public List<RelayMode> getFinal() {
		return relayModeRep.findFinal();
	}
	
	public RelayMode add(RelayMode relaymode) {
		return relayModeRep.save(relaymode);
	}
}
