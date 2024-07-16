package com.reports.DTOs;

import java.time.LocalDate;

public record ResponseReportDTO(LocalDate date,
                                String title,
                                String author,
                                String description,
                                Boolean edited){
}
