package com.hellogrok.domain.model;

import java.time.Instant;
import java.util.Objects;

/**
 * Domain model - Pure business object with no framework dependencies.
 */
public final class Greeting {

    private final String message;
    private final Instant createdAt;
    private final String source;

    public Greeting(String message, Instant createdAt, String source) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        this.message = message;
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.source = source != null ? source : "system";
    }

    public String getMessage() {
        return message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(message, greeting.message) &&
               Objects.equals(createdAt, greeting.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, createdAt);
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                ", createdAt=" + createdAt +
                ", source='" + source + '\'' +
                '}';
    }
}
