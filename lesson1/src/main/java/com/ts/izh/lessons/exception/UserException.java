package com.ts.izh.lessons.exception;

public class UserException extends Exception {

    public UserException(String msg, Throwable e) {
        super(msg, e);
    }
}
