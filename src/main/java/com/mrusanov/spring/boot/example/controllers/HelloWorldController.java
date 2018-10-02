package com.mrusanov.spring.boot.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
    }

}
