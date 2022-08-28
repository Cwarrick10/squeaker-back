package com.twitterclone.squeaker.exception;

public class SqueakerNotFoundException extends RuntimeException {
    static final long serialVersionUID = 3340780939361442441L;

    public SqueakerNotFoundException(String message) {
        super(message);
    }
}
