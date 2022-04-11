package com.bah.mcc.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {

	@RequestMapping
	public String getMessage() {
		return "team one App is running fine!";
	}
}
