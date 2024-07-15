package com.reports.model.entities;

import com.reports.DTOs.RequestReportDataDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "report")
@NoArgsConstructor
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate date;
    private String title;
    private String author;
    private String description;
    private Boolean edited;

    public Report(RequestReportDataDTO data){
        this.date = LocalDate.now();
        this.title = data.title();
        this.author = data.author();
        this.description = data.description();
        this.edited = false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
}

