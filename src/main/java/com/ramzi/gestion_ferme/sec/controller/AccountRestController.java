package com.ramzi.gestion_ferme.sec.controller;

import com.ramzi.gestion_ferme.sec.Entities.AppRole;
import com.ramzi.gestion_ferme.sec.Entities.AppUser;
import com.ramzi.gestion_ferme.sec.service.AccountService;
import lombok.Data;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private  AccountService accountService;

    public AccountRestController( AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/users")
    @PostAuthorize("hasAuthority('USER')")
    public List<AppUser>appUsers(){
        return accountService.listUsers();
    }

    @PostMapping(path ="/users")
    @PostAuthorize("hasAuthority('USER')")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping(path ="/roles")
    @PostAuthorize("hasAuthority('USER')")
    public AppRole saveUser(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @PostMapping(path ="/addRoleToUser")
    @PostAuthorize("hasAuthority('USER')")
    public void  addRoleToUser (@RequestBody RoleUserFrom roleUserFrom){
         accountService.addRoleToUser(roleUserFrom.getUsername(),roleUserFrom.getRoleName());
    }
}
@Data
  class RoleUserFrom{
    private String username;
    private  String roleName;
  }