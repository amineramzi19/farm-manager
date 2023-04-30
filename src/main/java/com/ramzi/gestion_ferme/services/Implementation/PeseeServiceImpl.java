package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Pesee;
import com.ramzi.gestion_ferme.repositories.PeseeRepository;
import com.ramzi.gestion_ferme.services.PeseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PeseeServiceImpl implements PeseeService {
    @Autowired
    private PeseeRepository peseeRepository;
    @Override
    public Pesee CreateUpdatePesee(Pesee pesee) {
        return peseeRepository.save(pesee);
    }

    @Override
    public List<Pesee> getAllPesee() {
        return peseeRepository.findAll();
    }

    @Override
    public Pesee getPeseeById(Long Id) {
        return peseeRepository.findById(Id).get();
    }

    @Override
    public void deletePesee(Pesee pesee) {
        peseeRepository.delete(pesee);
    }
}
