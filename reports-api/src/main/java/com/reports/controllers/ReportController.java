package com.reports.controllers;

import com.reports.DTOs.DateAndTitleRequestReportDTO;
import com.reports.DTOs.RequestEditReportDTO;
import com.reports.DTOs.RequestReportDataDTO;
import com.reports.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public ResponseEntity getReports(){
        return ResponseEntity.status(200).body(reportService.findAllReports().reportList());
    }
    @GetMapping("/find-report")
    public ResponseEntity getReport(@RequestBody DateAndTitleRequestReportDTO data){
        return ResponseEntity.status(200).body(reportService.findReport(data.date(), data.title()));
    }

    @PostMapping
    public ResponseEntity createReport(@RequestBody RequestReportDataDTO dataDTO){
        return ResponseEntity.status(200).body(reportService.createReport(dataDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateReport(@RequestBody RequestEditReportDTO requestEditReportDTO){
        return ResponseEntity.status(200).body(reportService.editReport(requestEditReportDTO));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteReport(@RequestBody DateAndTitleRequestReportDTO deleteReportDTO){
        return ResponseEntity.status(200).build();
    }
}
