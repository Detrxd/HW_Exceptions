package ru.netology.domain;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(String message) {
        super(message);
    }
}

