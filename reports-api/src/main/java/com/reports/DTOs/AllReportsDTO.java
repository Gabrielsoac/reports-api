package com.reports.DTOs;

import com.reports.model.entities.Report;

import java.util.List;

public record AllReportsDTO(List<Report> reportList) {
}
