package com.hellogrok.application.usecase;

import com.hellogrok.domain.model.Greeting;
import com.hellogrok.port.out.GreetingRepository;

import java.time.Instant;

/**
 * Concrete implementation of the use case.
 * This is where business orchestration happens.
 */
public class GenerateGreetingService implements GenerateGreetingUseCase {

    private final GreetingRepository greetingRepository;

    public GenerateGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting generateHelloGreeting(String requestedBy) {
        String message = "Hello from Hexagonal Architecture!";

        Greeting greeting = new Greeting(
                message,
                Instant.now(),
                requestedBy != null ? requestedBy : "anonymous"
        );

        greetingRepository.save(greeting);

        return greeting;
    }
}
