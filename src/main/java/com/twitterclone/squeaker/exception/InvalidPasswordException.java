package com.twitterclone.squeaker.exception;

public class InvalidPasswordException extends RuntimeException {
    static final long serialVersionUID = -8166885051524223615L;

    public InvalidPasswordException(String message) {
        super(message);
    }
}
