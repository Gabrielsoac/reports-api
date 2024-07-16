package com.reports.controllers;

import com.reports.DTOs.*;
import com.reports.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ResponseReportDTO>> getReports(){
        return ResponseEntity.status(200).body(reportService.findAllReports().reportList());
    }
    @GetMapping("/find-report")
    public ResponseEntity<ResponseReportDTO> getReport(@RequestBody RequestDateAndTitleReportDTO data){
        return ResponseEntity.status(200).body(reportService.findReport(data.date(), data.title()));
    }

    @PostMapping
    public ResponseEntity<ResponseReportDTO> createReport(@RequestBody RequestReportDataDTO dataDTO){
        return ResponseEntity.status(200).body(reportService.createReport(dataDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ResponseReportEditDTO> updateReport(@RequestBody RequestEditReportDTO requestEditReportDTO){
        return ResponseEntity.status(200).body(reportService.editReport(requestEditReportDTO));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteReport(@RequestBody RequestDateAndTitleReportDTO deleteReportDTO){
        return ResponseEntity.status(200).build();
    }
}
