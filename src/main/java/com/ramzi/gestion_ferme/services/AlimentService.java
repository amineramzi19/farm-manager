package com.ramzi.gestion_ferme.services;

import com.ramzi.gestion_ferme.entities.Aliment;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AlimentService {
    Aliment CreateUpdateAliment(Aliment aliment);
    List<Aliment> getAllAliment();
    Aliment getAlimentById(Long Id);
    void deleteAliment(Aliment aliment);
}