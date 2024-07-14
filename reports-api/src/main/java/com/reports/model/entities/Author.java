package com.reports.model.entities;

import jakarta.persistence.*;

@Table(name = "author")
@Entity(name = "author")
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    public Author(String name){
        this.name = name;
    }
    public Author() {

    }

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
