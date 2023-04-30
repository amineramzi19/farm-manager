package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Situation;
import com.ramzi.gestion_ferme.repositories.SituationRepository;
import com.ramzi.gestion_ferme.services.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SituationServiceImpl implements SituationService {
    @Autowired
    private SituationRepository situationRepository;
    @Override
    public Situation CreateUpdateSituation(Situation situation) {
        return situationRepository.save(situation);
    }

    @Override
    public List<Situation> getAllSituation() {
        return situationRepository.findAll();
    }

    @Override
    public Situation getSituationById(Long Id) {
        return situationRepository.findById(Id).get();
    }

    @Override
    public void deleteSituation(Situation situation) {
        situationRepository.delete(situation);
    }
}
