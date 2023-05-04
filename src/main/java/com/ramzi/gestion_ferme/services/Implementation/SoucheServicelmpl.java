package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Souche;
import com.ramzi.gestion_ferme.repositories.SoucheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoucheServicelmpl implements SoucheService{
    @Autowired
    private SoucheRepository soucheRepository;

    @Override
    public Souche CreateUpdateSouche(Souche souche) { soucheRepository.save(souche);
        return souche;
    }

    @Override
    public List<Souche> getAllSouche() {
         return soucheRepository.findAll();
    }

    @Override
    public Souche getSoucheById(Long Id) {
        return soucheRepository.findById(Id).get();
    }

    @Override
    public void deleteSouche(Souche souche) {
        soucheRepository.delete(souche);

    }
}
