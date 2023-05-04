package com.ramzi.gestion_ferme.web;

import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.Souche;
import com.ramzi.gestion_ferme.services.Implementation.SoucheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SouchController {
    @Autowired
    private SoucheService soucheService;
    private ResponseDto responseDto = new ResponseDto();
    public List<String> ErrorMessages;
    @GetMapping("/souches")
    public ResponseDto listSouche(){
        try{
            List<Souche> souches = soucheService.getAllSouche();
            responseDto.setResult(souches);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @GetMapping("/souches/{id}")
    public ResponseDto soucheById(@PathVariable Long id){
        try{
            Souche souche = soucheService.getSoucheById(id);
            responseDto.setResult(souche);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PostMapping("/souches")
    public ResponseDto saveSouche(@RequestBody Souche souche){
        try{
            soucheService.CreateUpdateSouche(souche);
            responseDto.setResult(souche);
            responseDto.setResult(souche);
            responseDto.setDisplayMessage("Souche added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PutMapping("souches")
    public ResponseDto updateSouche(@RequestBody Souche souche){
        try{
            soucheService.CreateUpdateSouche(souche);
            responseDto.setResult(souche);
            responseDto.setResult(souche);
            responseDto.setDisplayMessage("Souche added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @DeleteMapping("/souches/{id}")
    public ResponseDto deletesSouche(@PathVariable Long id){
        try {
            Souche souche = soucheService.getSoucheById(id);
            if(souche != null) {
                soucheService.deleteSouche(souche);
                responseDto.setDisplayMessage("Souche supprime");
                responseDto.setResult(souche);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Souche not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }

}
