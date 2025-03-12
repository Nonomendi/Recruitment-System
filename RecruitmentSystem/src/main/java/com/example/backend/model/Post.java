package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String businessUnit;
    private String managerName;
    private String managerEmail;
    private String experienceYears;
    private String qualificationRequirements;
    private String driversLicenseRequired;
    private Date openingDate;
    private Date closingDate;

    public Post(Object o, String javaDeveloper, String developAndMaintainJavaApplications, String pretoria, String psira, String s) {
    }
}