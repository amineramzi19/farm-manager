package com.ramzi.gestion_ferme.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "Code_Batiment")
    private String codeBatiment;
    private String Type;
    private Long Capacite;
    private Long QteCourante;

    public void setQteCourante(Long courante) {
        this.QteCourante = courante;
    }
}
