package com.ramzi.gestion_ferme.web;


import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.Batiment;
import com.ramzi.gestion_ferme.services.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BatimentController {
    @Autowired
    private BatimentService batimentService;
    private ResponseDto responseDto = new ResponseDto();
    public List<String> ErrorMessages;

    @GetMapping("/batiments")
    public ResponseDto listAliment(){
        try{
            List<Batiment> batiments = batimentService.getAllBatiment();
            responseDto.setResult(batiments);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @GetMapping("/batiments/{id}")
    public ResponseDto batimentById(@PathVariable Long id) {
        try {
            Batiment batiment = batimentService.getBatimentById(id);
            responseDto.setResult(batiment);
        } catch (Exception ex) {
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }

    @PostMapping("/batiments")
    public ResponseDto saveBatiment(@RequestBody Batiment batiment){
        try{
            batimentService.CreateUpdateBatiment(batiment);
            responseDto.setResult(batiment);
            responseDto.setResult(batiment);
            responseDto.setDisplayMessage("Aliment added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PutMapping("/batiments")
    public ResponseDto updateBatiment(@RequestBody Batiment batiment){
        try{
            batimentService.CreateUpdateBatiment(batiment);
            responseDto.setResult(batiment);
            responseDto.setResult(batiment);
            responseDto.setDisplayMessage("Batiment added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @DeleteMapping("/batiments/{id}")
    public ResponseDto deleteBatiment(@PathVariable Long id){
        try {
            Batiment batiment = batimentService.getBatimentById(id);
            if(batiment != null) {
                batimentService.deleteBatiment(batiment);
                responseDto.setDisplayMessage("Batiment supprime");
                responseDto.setResult(batiment);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Batiment not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }

}
