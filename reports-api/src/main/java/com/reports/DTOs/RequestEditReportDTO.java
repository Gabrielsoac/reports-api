package com.reports.DTOs;

import com.reports.model.entities.Author;

import java.time.LocalDate;

public record RequestEditReportDTO(LocalDate date,
                                   String title,
                                   Author author,
                                   String description) {
}
