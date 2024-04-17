package com.unafiber.report.core.entities.exceptions;

public class ReportNotFoundException extends RuntimeException{

    public ReportNotFoundException(String message) {
        super(message);
    }
}
