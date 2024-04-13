package com.unafiber.report.configs;

import com.unafiber.report.core.entities.exceptions.ReportAlreadyExists;
import com.unafiber.report.core.entities.exceptions.ReportNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ReportExceptionHandler {

    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity handlerReportNotFound(ReportNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ReportAlreadyExists.class)
    public ResponseEntity handlerReportAlreadyExists(ReportAlreadyExists e){
        return ResponseEntity.ok(e.getMessage());
    }
}
