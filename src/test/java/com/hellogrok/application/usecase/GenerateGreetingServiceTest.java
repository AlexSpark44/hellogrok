package com.hellogrok.application.usecase;

import com.hellogrok.adapter.out.persistence.InMemoryGreetingRepository;
import com.hellogrok.domain.model.Greeting;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateGreetingServiceTest {

    @Test
    void shouldGenerateGreetingAndPersistIt() {
        InMemoryGreetingRepository repository = new InMemoryGreetingRepository();
        GenerateGreetingUseCase useCase = new GenerateGreetingService(repository);

        Greeting greeting = useCase.generateHelloGreeting("test-user");

        assertThat(greeting.getMessage()).isEqualTo("Hello from Hexagonal Architecture!");
        assertThat(greeting.getSource()).isEqualTo("test-user");
        assertThat(repository.findAll()).hasSize(1);
    }
}
