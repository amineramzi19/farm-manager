package com.ramzi.gestion_ferme.sec.service;

import com.ramzi.gestion_ferme.sec.Entities.AppRole;
import com.ramzi.gestion_ferme.sec.Entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
    List<AppUser> listUsers();
}
