package com.reports.services;


import com.reports.DTOs.AllReportsDTO;
import com.reports.DTOs.ReportResponseDTO;
import com.reports.DTOs.RequestEditReportDTO;
import com.reports.DTOs.RequestReportDataDTO;
import com.reports.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public ReportResponseDTO createReport(RequestReportDataDTO data){

    }

    public ReportResponseDTO findReport(LocalDate date, String title){

    }

    public AllReportsDTO findAllReports(){

    }

    public ReportResponseDTO editReport(RequestEditReportDTO data){

    }

    public void removeReport(LocalDate date, String title){

    }



}
