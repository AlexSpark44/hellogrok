package com.hellogrok.port.out;

import com.hellogrok.domain.model.Greeting;

/**
 * Output Port (driven port).
 * The application layer depends on this interface.
 * Concrete implementation lives in the adapter layer.
 */
public interface GreetingRepository {

    Greeting save(Greeting greeting);
}
