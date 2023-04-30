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
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date DateCourant;
    private Long NoPapier;
    private String CodeBatiment;
    private String CodeAliment;
    private Long QteAliment;
    private Long Mortalite;
    private Long Tris;
    private String EffectifMale;
    private String EffectifFemale;
    private String Status;

}