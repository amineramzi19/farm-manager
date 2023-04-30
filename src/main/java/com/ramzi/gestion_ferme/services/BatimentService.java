package com.ramzi.gestion_ferme.services;

import com.ramzi.gestion_ferme.entities.Batiment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatimentService {
    void CreateUpdateBatiment(Batiment batiment);
    List<Batiment> getAllBatiment();
    Batiment getBatimentById(Long Id);
    void deleteBatiment(Batiment batiment);
}
