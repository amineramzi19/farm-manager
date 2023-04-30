package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Batiment;
import com.ramzi.gestion_ferme.repositories.BatimentRepository;
import com.ramzi.gestion_ferme.services.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BatimentServiceImpl implements BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;
    @Override
    public void CreateUpdateBatiment(Batiment batiment) {
        batimentRepository.save(batiment);
    }

    @Override
    public List<Batiment> getAllBatiment() {
        return batimentRepository.findAll();
    }

    @Override
    public Batiment getBatimentById(Long Id) {
        return batimentRepository.findById(Id).get();
    }

    @Override
    public void deleteBatiment(Batiment batiment) {
        batimentRepository.delete(batiment);
    }
}
