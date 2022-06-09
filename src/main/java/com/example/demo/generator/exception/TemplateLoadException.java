package com.example.demo.generator.exception;

public class TemplateLoadException extends RuntimeException {

    private static final String MESSAGE = "Template load problem.";

    public TemplateLoadException(Exception e) {
        super(MESSAGE, e);
    }
}
