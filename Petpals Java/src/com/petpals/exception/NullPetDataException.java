package com.petpals.exception;

public class NullPetDataException extends Exception {
    private static final long serialVersionUID = 1L;
    public NullPetDataException(String message) {
        super(message);
    }
}
