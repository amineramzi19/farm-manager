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
    private Long EchantillonMale;
    private Long EchantillonFemale;
    private Double PoidsMale;
    private Double PoidsFemale;
    private String Status;
}
