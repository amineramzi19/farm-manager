package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Consommation;
import com.ramzi.gestion_ferme.repositories.ConsommationReposioty;
import com.ramzi.gestion_ferme.services.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsommationServiceImpl implements ConsommationService {
    @Autowired
    private ConsommationReposioty consommationReposioty;
    @Override
    public Consommation CreateUpdateConsommation(Consommation consommation) {
        return consommationReposioty.save(consommation);
    }

    @Override
    public List<Consommation> getAllConsommation() {
        return consommationReposioty.findAll();
    }

    @Override
    public Consommation getConsommationById(Long Id) {
        return consommationReposioty.findById(Id).get();
    }

    @Override
    public void deleteConsommation(Consommation consommation) {
        consommationReposioty.delete(consommation);
    }
}
