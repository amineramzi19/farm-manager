package com.ramzi.gestion_ferme.repositories;

import com.ramzi.gestion_ferme.entities.Consommation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsommationReposioty extends JpaRepository<Consommation, Long> {
}
