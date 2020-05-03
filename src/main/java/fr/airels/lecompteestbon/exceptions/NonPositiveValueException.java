package fr.airels.lecompteestbon.exceptions;

public class NonPositiveValueException extends Exception {
    public NonPositiveValueException(String errorMessage) {
        super(errorMessage);
    }
}
