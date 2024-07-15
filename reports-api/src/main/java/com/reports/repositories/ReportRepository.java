package com.reports.repositories;

import com.reports.model.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface ReportRepository extends JpaRepository<Report, String> {

    Report findReportByDateAndTitle(LocalDate date, String title);

}
