package com.hellogrok.application.usecase;

import com.hellogrok.domain.model.Greeting;

/**
 * Application layer - Orchestrates business logic.
 * Depends only on domain and ports (interfaces), never on concrete adapters.
 */
public interface GenerateGreetingUseCase {

    Greeting generateHelloGreeting(String requestedBy);
}
