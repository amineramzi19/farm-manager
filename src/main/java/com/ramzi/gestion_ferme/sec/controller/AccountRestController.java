package com.ramzi.gestion_ferme.sec.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramzi.gestion_ferme.sec.Entities.AppRole;
import com.ramzi.gestion_ferme.sec.Entities.AppUser;
import com.ramzi.gestion_ferme.sec.service.AccountService;
import lombok.Data;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AccountRestController {
    private  AccountService accountService;

    public AccountRestController( AccountService accountService) {
        this.accountService = accountService;
    }
//    @GetMapping("/profile")
//    public AppUser profile(Principal principal){
//        return accountService.loadUserByUserName(principal.getName());
//    }
    @GetMapping(path = "/users")
    @PostAuthorize("hasAuthority('USER')")
    public List<AppUser>appUsers(){
        return accountService.listUsers();
    }

    @PostMapping(path ="/users")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping(path ="/roles")
    @PostAuthorize("hasAuthority('ADMIN')")

    public AppRole saveUser(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @PostMapping(path ="/addRoleToUser")
   // @PostAuthorize("hasAuthority('USER')")
    public void  addRoleToUser (@RequestBody RoleUserFrom roleUserFrom){
         accountService.addRoleToUser(roleUserFrom.getUsername(),roleUserFrom.getRoleName());
    }
    @GetMapping(path = "/refreshTokn")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String auhToken=request.getHeader("Authorization");
        if (auhToken!=null && auhToken.startsWith("Bearer ")){

            try {
                String jwt = auhToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("mySecret1234");
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username=decodedJWT.getSubject();
                AppUser appUser=accountService.loadUserByUserName(username);
                String jwtAccessToken= JWT.create()
                        .withSubject(appUser.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+5*60*1000))
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles",appUser.getAppRoles().stream().map(r->r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> idToken=new HashMap<>();
                idToken.put("access-token",jwtAccessToken);
                idToken.put("refresh_Tokn",jwt);
//                idToken.put("nom","");
//                idToken.put("filiale","");
//                idToken.put("batiment","");
//                idToken.put("lot","");
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(),idToken);


            }
            catch (Exception e) {
                throw e;

            }

        }
        else {
            throw new RuntimeException("Refersh tokn required!!!");

        }

    }
}
@Data
  class RoleUserFrom{
    private String username;
    private  String roleName;
  }