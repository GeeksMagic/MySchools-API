package com.gmt.myschool;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

	@RequestMapping("/welcome")
	public String doWelcome(){
		//Response.status(Status.ACCEPTED).build();
		return "{\"data\":\"Welcome to My School\"}";
	}
	
}
