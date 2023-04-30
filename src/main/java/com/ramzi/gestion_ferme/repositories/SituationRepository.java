package com.ramzi.gestion_ferme.repositories;

import com.ramzi.gestion_ferme.entities.Situation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituationRepository extends JpaRepository<Situation, Long> {
}
