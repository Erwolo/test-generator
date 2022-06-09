package com.example.demo.generator.exception;

public class TemplatesFolderNotFoundRuntimeException extends RuntimeException {

    private static final String MESSAGE = "Templates folder not found.";

    public TemplatesFolderNotFoundRuntimeException(Exception e) {
        super(MESSAGE, e);
    }

}
