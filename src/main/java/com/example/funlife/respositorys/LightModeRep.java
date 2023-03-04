package com.example.funlife.respositorys;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.funlife.models.LightMode;

@Repository
public interface LightModeRep extends MongoRepository<LightMode, String>{
	@Aggregation(pipeline = { 
		    "{ '$sort' : { '_id' : -1 } }",
		    "{ '$limit' : 1 }"
	})
	List<LightMode> findFinal();
}
