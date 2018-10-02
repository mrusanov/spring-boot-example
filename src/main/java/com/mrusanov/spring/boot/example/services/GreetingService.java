package com.mrusanov.spring.boot.example.services;

import com.mrusanov.spring.boot.example.persistence.entities.Greeting;

import java.util.List;

public interface GreetingService {

    List<Greeting> getAllGreetings();

    void postGreeting(Greeting greeting);

}
