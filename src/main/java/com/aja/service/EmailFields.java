package com.aja.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailFields {

	private String to;
	private String name;
	
	private String body;
	
	private String subject;

}
