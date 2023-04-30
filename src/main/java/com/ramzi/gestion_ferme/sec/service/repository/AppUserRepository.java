package com.ramzi.gestion_ferme.sec.service.repository;

import com.ramzi.gestion_ferme.sec.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
