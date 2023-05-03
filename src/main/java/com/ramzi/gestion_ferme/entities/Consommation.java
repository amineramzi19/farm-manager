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
public class Consommation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date DateCourante;
    private Long NoPapier;
    private Long QteGaz;
    private Long QteGasoil;
    private Long Paille;
    private String lot;
    private String batiment;
    private String Status;


}
