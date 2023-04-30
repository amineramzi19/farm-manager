package com.ramzi.gestion_ferme.repositories;

import com.ramzi.gestion_ferme.entities.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentRepository extends JpaRepository<Aliment, Long> {
}
