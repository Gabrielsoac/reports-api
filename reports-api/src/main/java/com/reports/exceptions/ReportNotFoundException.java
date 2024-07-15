package com.reports.exceptions;

public class ReportNotFoundException extends RuntimeException {

    public ReportNotFoundException(String message) {
        super(message);
    }
}
