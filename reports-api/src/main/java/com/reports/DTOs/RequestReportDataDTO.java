package com.reports.DTOs;

import com.reports.model.entities.Author;

public record RequestReportDataDTO(String title,
                                   Author author,
                                   String description) {
}
