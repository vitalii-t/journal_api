package com.journal.exceptions;

public class JournalException extends RuntimeException {
    public JournalException(Exception e) {
        super(e);
    }

    public JournalException(String msg) {
        super(msg);
    }

    public JournalException(String format, Object... args) {
        super(String.format(format, args));
    }

    public JournalException(String message, Exception e) {
        super(message, e);
    }
}