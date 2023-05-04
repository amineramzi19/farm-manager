package com.ramzi.gestion_ferme.repositories;

import com.ramzi.gestion_ferme.entities.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot, Long> {
}
