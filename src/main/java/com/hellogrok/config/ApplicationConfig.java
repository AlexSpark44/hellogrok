package com.hellogrok.config;

import com.hellogrok.adapter.out.persistence.InMemoryGreetingRepository;
import com.hellogrok.application.usecase.GenerateGreetingService;
import com.hellogrok.application.usecase.GenerateGreetingUseCase;
import com.hellogrok.port.out.GreetingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Manual wiring of hexagonal components.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public GreetingRepository greetingRepository() {
        return new InMemoryGreetingRepository();
    }

    @Bean
    public GenerateGreetingUseCase generateGreetingUseCase(GreetingRepository greetingRepository) {
        return new GenerateGreetingService(greetingRepository);
    }
}
