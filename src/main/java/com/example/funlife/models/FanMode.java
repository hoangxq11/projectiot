package com.example.funlife.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fanmode")
public class FanMode {
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private String id;
	private String mode;
	
	
}
