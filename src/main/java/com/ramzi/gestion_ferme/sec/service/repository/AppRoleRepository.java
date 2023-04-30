package com.ramzi.gestion_ferme.sec.service.repository;

import com.ramzi.gestion_ferme.sec.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
