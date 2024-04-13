package com.unafiber.report.core.entities.exceptions;

public class ReportAlreadyExists extends RuntimeException{
    public ReportAlreadyExists(String message) {
        super(message);
    }
}
