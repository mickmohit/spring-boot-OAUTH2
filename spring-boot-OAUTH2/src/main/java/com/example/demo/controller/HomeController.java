package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/asd")
	public String privat() {return "private";}
	
	@GetMapping(value = "/")
    public String index(){
        return "Hello world";
    }

}
