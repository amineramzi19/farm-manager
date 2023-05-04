package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Souche;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SoucheService {

        Souche CreateUpdateSouche(Souche souche);
        List<Souche> getAllSouche();
        Souche getSoucheById(Long Id);
        void deleteSouche(Souche souche);
}
