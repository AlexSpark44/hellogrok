package com.hellogrok.adapter.in.web;

import com.hellogrok.application.usecase.GenerateGreetingUseCase;
import com.hellogrok.domain.model.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Inbound Adapter (driving adapter).
 * Translates HTTP requests into calls to the application layer.
 */
@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    private final GenerateGreetingUseCase generateGreetingUseCase;

    public GreetingController(GenerateGreetingUseCase generateGreetingUseCase) {
        this.generateGreetingUseCase = generateGreetingUseCase;
    }

    @GetMapping("/hello")
    public ResponseEntity<Map<String, Object>> sayHello(
            @RequestParam(value = "requestedBy", required = false, defaultValue = "developer") String requestedBy) {

        Greeting greeting = generateGreetingUseCase.generateHelloGreeting(requestedBy);

        return ResponseEntity.ok(Map.of(
                "message", greeting.getMessage(),
                "source", greeting.getSource(),
                "timestamp", greeting.getCreatedAt().toString(),
                "architecture", "Hexagonal Architecture (Ports & Adapters)",
                "note", "This response went through Domain → Application → Port → Adapter"
        ));
    }
}
