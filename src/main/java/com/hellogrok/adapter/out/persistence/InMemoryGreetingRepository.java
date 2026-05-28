package com.hellogrok.adapter.out.persistence;

import com.hellogrok.domain.model.Greeting;
import com.hellogrok.port.out.GreetingRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the output port.
 * Used for early development and testing.
 * Will be replaced by a real JPA adapter later.
 */
public class InMemoryGreetingRepository implements GreetingRepository {

    private final List<Greeting> greetings = new ArrayList<>();

    @Override
    public Greeting save(Greeting greeting) {
        greetings.add(greeting);
        System.out.println("[InMemoryGreetingRepository] Saved greeting: " + greeting.getMessage());
        return greeting;
    }

    public List<Greeting> findAll() {
        return List.copyOf(greetings);
    }
}
