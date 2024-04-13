package com.unafiber.report.core.DTOs;

import com.unafiber.report.core.entities.Report;

import java.util.List;

public record ReportResponseListDTO(List<Report> reports) {
}
