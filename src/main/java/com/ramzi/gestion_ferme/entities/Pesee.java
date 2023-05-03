package com.ramzi.gestion_ferme.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Pesee {
    //public Object setDatePesee;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date DatePesee;


    private Long NoPapier;
    private String CodeBatiment;
    private String EchantillonMale;
    private String EchantillonFemale;
    private String HomogeneteMale;
    private String HomogeneteFemale;
    private Long PoidsMale;
    private Long PoidsFemale;
    private String lot;
    private String batiment;
    private String Status;
}
