package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Lot;
import com.ramzi.gestion_ferme.repositories.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotServicelmpl implements LotService {
    @Autowired
    private LotRepository lotRepository;

    @Override
    public Lot CreateUpdateLot(Lot lot) { lotRepository.save(lot);
        return lot;
    }

    @Override
    public List<Lot> getAllLot() {
        return lotRepository.findAll();
    }

    @Override
    public Lot getLotById(Long Id) {
        return lotRepository.findById(Id).get();
    }

    @Override
    public void deleteLot(Lot lot) {
        lotRepository.delete(lot);

    }
}
