package com.reports.DTOs;

import java.time.LocalDate;

public record ReportResponseDTO (LocalDate date,
                                 String title,
                                 String author,
                                 String description){
}
