package com.ramzi.gestion_ferme.services;

import com.ramzi.gestion_ferme.entities.Consommation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ConsommationService {
    Consommation CreateUpdateConsommation(Consommation consommation);
    List<Consommation> getAllConsommation();
    Consommation getConsommationById(Long Id);
    void deleteConsommation(Consommation consommation);
}
