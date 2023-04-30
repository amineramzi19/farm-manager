package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Aliment;
import com.ramzi.gestion_ferme.repositories.AlimentRepository;
import com.ramzi.gestion_ferme.services.AlimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentServiceImpl implements AlimentService {
    @Autowired
    private AlimentRepository alimentRepository;
    @Override
    public Aliment CreateUpdateAliment(Aliment aliment) {
        alimentRepository.save(aliment);
        return aliment;
    }

    @Override
    public List<Aliment> getAllAliment() {
        return alimentRepository.findAll();
    }

    @Override
    public Aliment getAlimentById(Long Id) {
        return alimentRepository.findById(Id).get();
    }

    @Override
    public void deleteAliment(Aliment aliment) {
        alimentRepository.delete(aliment);
    }
}
