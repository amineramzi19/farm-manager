package com.ramzi.gestion_ferme.services;

import com.ramzi.gestion_ferme.entities.Consommation;
import com.ramzi.gestion_ferme.entities.Pesee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeseeService {
    Pesee CreateUpdatePesee(Pesee pesee);
    List<Pesee> getAllPesee();
    Pesee getPeseeById(Long Id);
    void deletePesee(Pesee pesee);
}
