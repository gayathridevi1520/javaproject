package com.example.tabledemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {
@GetMapping("/")
public String hellomethod(){
    return "hello,gayathri you have successfully create web app";
}

    
}
