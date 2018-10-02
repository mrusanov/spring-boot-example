package com.mrusanov.spring.boot.example.services;

import com.mrusanov.spring.boot.example.persistence.entities.Greeting;
import com.mrusanov.spring.boot.example.persistence.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public void postGreeting(Greeting greeting) {
        greetingRepository.save(greeting);
    }

}
