package com.unafiber.report.controllers;

import com.unafiber.report.core.DTOs.*;
import com.unafiber.report.core.entities.Report;
import com.unafiber.report.services.ReportRepositoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/reports")
public class ReportController {

    private final ReportRepositoryService reportRepositoryService;

    @GetMapping
    public ResponseEntity<ReportResponseListOnlyDateDTO> getAllRelatoriosByDates() {
        ReportResponseListOnlyDateDTO reportList = reportRepositoryService.findAllReports();
        return ResponseEntity.ok(reportList);
    }
    /*
    @GetMapping
    public ResponseEntity<ReportResponseListDTO> getAllRelatorios() {
       ReportResponseListDTO reportList = reportRepositoryService.findAllReports();
        return ResponseEntity.ok(reportList);
    } */

    @GetMapping("/{date}")
    public ResponseEntity<ReportResponseDTO> getReportById(@PathVariable LocalDate date) {
        ReportResponseDTO report = reportRepositoryService.findReportByData(date);
        return ResponseEntity.ok(report);
    }

    @PostMapping
    public ResponseEntity<ReportDateDTO> saveRelatorio(@RequestBody ReportRequestDTO data) {
        Report newReport = new Report(data);
        ReportDateDTO report = reportRepositoryService.SaveReport(newReport);
        return ResponseEntity.ok(report);
    }

    @DeleteMapping("/{date}")
    @Transactional
    public ResponseEntity deleteRelatorioByDate(@PathVariable LocalDate date) {
        reportRepositoryService.deleteReportByDate(date);
        return ResponseEntity.ok("Deleted!");
    }
}
