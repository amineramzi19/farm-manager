package com.ramzi.gestion_ferme.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor

public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

   // @Column(name = "code")
    private String code;

  //  @Column(name = "description")
    private String description;

   // @Column(name = "date_db")
   @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDb;

   // @Column(name = "id_la_souche")
    private static Long idLaSouche;

   // @Column(name = "id_batiment")
    private Long idBatiment;

    public static void idLaSouche(String s) {
    }
}
