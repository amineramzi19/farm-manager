package com.ramzi.gestion_ferme.services.Implementation;

import com.ramzi.gestion_ferme.entities.Lot;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LotService {
    Lot CreateUpdateLot(Lot lot);
    List<Lot> getAllLot();
    Lot getLotById(Long Id);
    void deleteLot(Lot lot);
}
