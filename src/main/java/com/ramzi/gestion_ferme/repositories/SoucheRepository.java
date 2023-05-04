package com.ramzi.gestion_ferme.repositories;

import com.ramzi.gestion_ferme.entities.Souche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoucheRepository extends JpaRepository<Souche, Long> {
}
