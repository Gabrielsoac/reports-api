package com.reports.services;


import com.reports.DTOs.*;
import com.reports.exceptions.ReportNotFoundException;
import com.reports.model.entities.Report;
import com.reports.repositories.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportResponseDTO createReport(RequestReportDataDTO data){
        Report newReport = new Report(data);
        reportRepository.save(newReport);
        return new ReportResponseDTO(newReport.getDate(), newReport.getTitle(), newReport.getAuthor(), newReport.getDescription());
    }

    public ReportResponseDTO findReport(LocalDate date, String title){

        Report report = findReportByDateAndTitle(date, title);

        return new ReportResponseDTO(report.getDate(), report.getTitle(), report.getAuthor(), report.getDescription());
    }

    public AllReportsDTO findAllReports(){

        List<ReportResponseDTO> reportList = reportRepository
                .findAll()
                .stream().map((x) -> new ReportResponseDTO(x.getDate(), x.getTitle(), x.getAuthor(), x.getDescription())).toList();
        return new AllReportsDTO(reportList);
    }

    public ReportResponseEditDTO editReport(RequestEditReportDTO data){

        Report report = findReportByDateAndTitle(data.date(), data.title());
        report.setTitle(data.title());
        report.setDescription(data.description());
        report.setAuthor(data.author());
        report.setEdited(true);

        return new ReportResponseEditDTO(report.getDate(), report.getTitle(), report.getAuthor(), report.getDescription(), report.getEdited());

    }

    public void removeReport(DateAndTitleRequestReportDTO data){
        reportRepository.delete(findReportByDateAndTitle(data.date(), data.title()));
    }

    private Report findReportByDateAndTitle(LocalDate date, String title){
        Optional<Report> reportOptional = Optional.ofNullable(reportRepository.findReportByDateAndTitle(date, title));
        if (reportOptional.isPresent()){
            Report report = reportOptional.get();
            return report;
        }
        throw new ReportNotFoundException("Report not found");
    }
}
