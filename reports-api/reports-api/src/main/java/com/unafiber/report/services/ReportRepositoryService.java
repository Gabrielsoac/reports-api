package com.unafiber.report.services;

import com.unafiber.report.core.DTOs.*;
import com.unafiber.report.core.entities.Report;
import com.unafiber.report.core.entities.exceptions.ReportAlreadyExists;
import com.unafiber.report.core.entities.exceptions.ReportNotFoundException;
import com.unafiber.report.repositories.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportRepositoryService {

    private final ReportRepository reportRepository;

    public ReportResponseListOnlyDateDTO findAllReports() {

        List<Report> reports = reportRepository.findAll();
        List<LocalDate> reportsDate = new ArrayList<>();

        for (Report report : reports) {
            reportsDate.add(report.getDate());
        }

        ReportResponseListOnlyDateDTO reportList = new ReportResponseListOnlyDateDTO(reportsDate);

        return reportList;
    }

    public ReportResponseDTO findReportByData(LocalDate date) {
        Optional<Report> reportOptional = Optional.ofNullable(reportRepository.findReportByDate(date));
        if (reportOptional.isPresent()) {
            return createReportResponseDTO(reportOptional.get());
        }
        throw new ReportNotFoundException("Report not Found!");
    }

    public Boolean deleteReportByDate(LocalDate date) {

        for(Report report : reportRepository.findAll()){
            if(report.getDate().equals(date)){
                reportRepository.deleteReportByDate(date);
                return true;
            }
        }
        throw new ReportNotFoundException("Report not Found!");
    }
    public void deleteReportById(String id) {
        Optional<Report> reportOptional = reportRepository.findById(id);
        if (reportOptional.isPresent()) {
            reportRepository.delete(reportOptional.get());
        }
        throw new ReportNotFoundException("Report not Found!");
    }

    public ReportDateDTO SaveReport (Report data){

        List<LocalDate> reportsDateList = new ArrayList<>();
        List<Report> reports = reportRepository.findAll();

        for (Report report : reports) {
            reportsDateList.add(report.getDate());
        }

        boolean dateAlreadyExists = reportsDateList.contains(data.getDate());

        if (dateAlreadyExists) {
            throw new ReportAlreadyExists("Report Already Exists");
        }
        reportRepository.save(data);
        return new ReportDateDTO(data.getDate());
    }

    private ReportResponseDTO createReportResponseDTO(Report report) {
        return new ReportResponseDTO(
                report.getDate(),
                report.getDay_week(),
                report.getLink_jadson_consumo(),
                report.getLink_df_consumo(),
                report.getLink_formosa_consumo(),
                report.getClients_online(),
                report.getClients_offline(),
                report.getClients_blocked(),
                report.getStatus_ar_is_ok(),
                report.getSwitch_huawei_core_is_ok(),
                report.getSwitch_datacom_link_is_ok(),
                report.getBgp_is_ok(),
                report.getConcentrador_is_ok(),
                report.getBackup_server_is_ok(),
                report.getA10_is_ok(),
                report.getFonte1_is_ok(),
                report.getFonte2_is_ok(),
                report.getFonte3_is_ok(),
                report.getQuadro1_is_ok(),
                report.getQuadro2_is_ok(),
                report.getQuadro3_is_ok(),
                report.getInversora_is_ok(),
                report.getOltc300_is_ok(),
                report.getOltc650_is_ok(),
                report.getWhatsapp_status(),
                report.getSystem_manager_is_ok(),
                report.getSite_is_ok(),
                report.getVoip_is_ok(),
                report.getDevices_ont(),
                report.getDevices_local());
    }
}


