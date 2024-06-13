package org.example.exercice6produitsj2ee.exeption;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
