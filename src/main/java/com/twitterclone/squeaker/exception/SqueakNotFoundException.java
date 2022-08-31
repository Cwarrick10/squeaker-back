package com.twitterclone.squeaker.exception;

public class SqueakNotFoundException extends RuntimeException {
    static final long serialVersionUID = -361228795522982593L;

    public SqueakNotFoundException(String message) {
        super(message);
    }
}
