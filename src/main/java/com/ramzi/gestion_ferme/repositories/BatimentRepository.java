package com.ramzi.gestion_ferme.repositories;

import com.ramzi.gestion_ferme.entities.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatimentRepository extends JpaRepository<Batiment, Long> {
}
