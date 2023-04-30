package com.ramzi.gestion_ferme.services;

import com.ramzi.gestion_ferme.entities.Situation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SituationService {
    Situation CreateUpdateSituation(Situation situation);
    List<Situation> getAllSituation();
    Situation getSituationById(Long Id);
    void deleteSituation(Situation situation);
}
