package com.reports.DTOs;

import java.time.LocalDate;

public record RequestEditReportDTO(LocalDate date,
                                   String title,
                                   String author,
                                   String description) {
}
