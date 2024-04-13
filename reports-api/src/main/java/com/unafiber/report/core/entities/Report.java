package com.unafiber.report.core.entities;

import com.unafiber.report.core.DTOs.ReportRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "report_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report {

    public Report(ReportRequestDTO data) {
        this.date = LocalDate.now();
        this.day_week = data.day_week();
        this.link_jadson_consumo = data.link_jadson_consumo();
        this.link_df_consumo = data.link_df_consumo();
        this.link_formosa_consumo = data.link_formosa_consumo();
        this.clients_online = data.clients_online();
        this.clients_offline = data.clients_offline();
        this.clients_blocked = data.clients_blocked();
        this.status_ar_is_ok = data.status_ar_is_ok();
        this.switch_huawei_core_is_ok = data.switch_huawei_core_is_ok();
        this.switch_datacom_link_is_ok = data.switch_datacom_link_is_ok();
        this.bgp_is_ok = data.bgp_is_ok();
        this.concentrador_is_ok = data.concentrador_is_ok();
        this.backup_server_is_ok = data.backup_server_is_ok();
        this.a10_is_ok = data.a10_is_ok();
        this.fonte1_is_ok = data.fonte1_is_ok();
        this.fonte2_is_ok = data.fonte2_is_ok();
        this.fonte3_is_ok = data.fonte3_is_ok();
        this.quadro1_is_ok = data.quadro1_is_ok();
        this.quadro2_is_ok = data.quadro2_is_ok();
        this.quadro3_is_ok = data.quadro3_is_ok();
        this.inversora_is_ok = data.inversora_is_ok();
        this.oltc300_is_ok = data.oltc300_is_ok();
        this.oltc650_is_ok = data.oltc650_is_ok();
        this.whatsapp_status = data.whatsapp_status();
        this.system_manager_is_ok = data.system_manager_is_ok();
        this.site_is_ok = data.site_is_ok();
        this.voip_is_ok = data.voip_is_ok();
        this.devices_ont = data.devices_ont();
        this.devices_local = data.devices_local();
    }

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private Integer day_week;

    @Column(nullable = false)
    private Double link_jadson_consumo;

    @Column(nullable = false)
    private Double link_df_consumo;

    @Column(nullable = false)
    private Double link_formosa_consumo;

    @Column(nullable = false)
    private Integer clients_online;

    @Column(nullable = false)
    private Integer clients_offline;

    @Column(nullable = false)
    private Integer clients_blocked;

    @Column(nullable = false)
    private Boolean status_ar_is_ok;

    @Column(nullable = false)
    private Boolean switch_huawei_core_is_ok;

    @Column(nullable = false)
    private Boolean switch_datacom_link_is_ok;

    @Column(nullable = false)
    private Boolean bgp_is_ok;

    @Column(nullable = false)
    private Boolean concentrador_is_ok;

    @Column(nullable = false)
    private Boolean backup_server_is_ok;

    @Column(nullable = false)
    private Boolean a10_is_ok;

    @Column(nullable = false)
    private Boolean fonte1_is_ok;

    @Column(nullable = false)
    private Boolean fonte2_is_ok;

    @Column(nullable = false)
    private Boolean fonte3_is_ok;

    @Column(nullable = false)
    private Boolean quadro1_is_ok;

    @Column(nullable = false)
    private Boolean quadro2_is_ok;

    @Column(nullable = false)
    private Boolean quadro3_is_ok;

    @Column(nullable = false)
    private Boolean inversora_is_ok;

    @Column(nullable = false)
    private Boolean oltc300_is_ok;

    @Column(nullable = false)
    private Boolean oltc650_is_ok;

    @Column(nullable = false)
    private String whatsapp_status;

    @Column(nullable = false)
    private Boolean system_manager_is_ok;

    @Column(nullable = false)
    private Boolean site_is_ok;

    @Column(nullable = false)
    private Boolean voip_is_ok;

    @Column(nullable = false)
    private Integer devices_ont;

    @Column(nullable = false)
    private Integer devices_local;
}
