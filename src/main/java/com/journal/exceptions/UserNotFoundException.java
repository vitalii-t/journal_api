package com.journal.exceptions;

public class UserNotFoundException extends JournalException {

    public UserNotFoundException(String msg) {
        super("UserNotFoundException: " + msg);
    }
}