package com.unafiber.report.repositories;

import com.unafiber.report.core.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, String> {

    Report findReportByDate(LocalDate date);
    void deleteReportByDate(LocalDate date);
}
