package com.mrusanov.spring.boot.example.controllers;

import com.mrusanov.spring.boot.example.persistence.entities.Greeting;
import com.mrusanov.spring.boot.example.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingRestController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/greetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Greeting>> getAllGreetings() {

        List<Greeting> greetings = greetingService.getAllGreetings();

        return ResponseEntity.ok(greetings);
    }


    @RequestMapping(value = "/greetings/post", method = RequestMethod.POST)
    public ResponseEntity<Greeting> postGreeting(@RequestHeader(name = "name", required = true) String name, @RequestBody(required = true) String message) {

        Greeting greeting = new Greeting(name, message);

        greetingService.postGreeting(greeting);

        return ResponseEntity.status(HttpStatus.CREATED).body(greeting);
    }

}
