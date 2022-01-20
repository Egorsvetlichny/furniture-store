package ru.esvetlichny.furniturestore.util;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

@Component
public class SimpleExample {
    public ExampleMatcher getMatcher() {
        return ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase();
    }
}
