package com.ramzi.gestion_ferme;

import com.ramzi.gestion_ferme.entities.*;
import com.ramzi.gestion_ferme.sec.Entities.AppRole;
import com.ramzi.gestion_ferme.sec.Entities.AppUser;
import com.ramzi.gestion_ferme.sec.service.AccountService;
import com.ramzi.gestion_ferme.services.AlimentService;
import com.ramzi.gestion_ferme.services.BatimentService;
import com.ramzi.gestion_ferme.services.ConsommationService;
import com.ramzi.gestion_ferme.services.Implementation.SituationServiceImpl;
import com.ramzi.gestion_ferme.services.PeseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;


@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class GestionFermeApplication implements CommandLineRunner {
    final AlimentService alimentService;
//
//    public GestionFermeApplication(AlimentService alimentService, BatimentService batimentService, ConsommationService consommationService, PeseeService peseeService, SituationServiceImpl situationService) {
//        this.alimentService = alimentService;
//        this.batimentService = batimentService;
//        this.consommationService = consommationService;
//        this.peseeService = peseeService;
//        this.situationService = situationService;
//    }
    @Autowired
    private BatimentService batimentService;
    @Autowired
    private  ConsommationService consommationService;
    @Autowired
    private PeseeService peseeService;
    @Autowired
    private SituationServiceImpl situationService;
    @Autowired
      AccountService accountService;



    public GestionFermeApplication(AlimentService alimentService) {
        this.alimentService = alimentService;
    }


    public static void main(String[] args) {
        SpringApplication.run(GestionFermeApplication.class, args);
    }
     @Bean
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner start(AccountService accountService){
       return args -> {
           accountService.addNewRole(new AppRole(null,"USER"));
           accountService.addNewRole(new AppRole(null,"ADMIN"));
           accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
           accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
           accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));

            accountService.addNewUser(new AppUser(null,"ZalarHolding","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user3","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user4","1234",new ArrayList<>()));

            accountService.addRoleToUser("ZalarHolding","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user3","PRODUCT_MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS_MANAGER");
        };
 }

    @Override
    public void run(String... args) throws Exception {

        for(int i = 0; i<5; i++){
            Aliment aliment = new Aliment();
            aliment.setCodeAliment("CC"+i);
            aliment.setDescription("Description CC"+i);
            alimentService.CreateUpdateAliment(aliment);

//
//            Batiment batiment = new Batiment();
//            batiment.setCode_Batiment("CC" +i);
//            batiment.setType("type CC" +i);
//            batiment.setCapacite(5l);
//            batiment.setQteCourante(5l);
//            batimentService.CreateUpdateBatiment(batiment);


            Consommation consommation = new Consommation();
            consommation.setDateCourante( new Date());
            consommation.setNoPapier(i+1254l);
            consommation.setQteGaz(78596l);
            consommation.setQteGasoil(6987l);
            consommation.setPaille(1252l);
            consommation.setBatiment("Batimen 12");
            consommation.setLot("xx");
            consommation.setStatus("Transmis" );

            consommationService.CreateUpdateConsommation(consommation);


            Pesee pesee = new  Pesee();
            pesee.setDatePesee( new Date());
            pesee.setNoPapier(i+4587l);
            pesee.setCodeBatiment("1A23BC56D"+i);
            pesee.setEchantillonMale("M");
            pesee.setEchantillonFemale("F");
            pesee.setPoidsMale(12l);
            pesee.setPoidsFemale(16l);
            pesee.setHomogeneteFemale("F");
            pesee.setHomogeneteMale("M");
            pesee.setBatiment("Batiment 12");
            pesee.setLot("xx");

            pesee.setStatus( "Non Transmis" );

            peseeService.CreateUpdatePesee(pesee);

            Situation situation = new Situation();
            situation.setDateCourant( new Date());
            situation.setNoPapier(87l +i);
            situation.setCodeBatiment("1A23BC56D"+i);
            situation.setCodeAliment("12152"+i);
            situation.setQteAliment(18l+i);
            situation.setMortalite(124L+i);
            situation.setTris(32l +i);
            situation.setBatiment("batiment 2");
            situation.setLot("xx");
            situation.setEffectifMale("AZ45ER25");
            situation.setEffectifFemale("3E5TRF15");
            situation.setStatus( "NoN Transmis" );


            situationService.CreateUpdateSituation(situation);
        }
    }
}
