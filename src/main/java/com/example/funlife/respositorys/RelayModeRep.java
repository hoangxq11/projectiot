package com.example.funlife.respositorys;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.funlife.models.RelayMode;

@Repository
public interface RelayModeRep extends MongoRepository<RelayMode, String>{
	@Aggregation(pipeline = { 
		    "{ '$sort' : { '_id' : -1 } }",
		    "{ '$limit' : 1 }"
	})
	List<RelayMode> findFinal();
}
