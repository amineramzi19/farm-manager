package com.ramzi.gestion_ferme.web;


import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.Consommation;
import com.ramzi.gestion_ferme.services.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ConsommationController {

    @Autowired
    private ConsommationService consommationService;
    private ResponseDto responseDto = new ResponseDto();
    public List<String> ErrorMessages;

    @GetMapping("/consommations")
    public ResponseDto listConsommation(){
        try{
            List<Consommation> consommations = consommationService.getAllConsommation();
            responseDto.setResult(consommations);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @GetMapping("/consommations/{id}")
    public ResponseDto consommationById(@PathVariable Long id) {
        try {
            Consommation consommation = consommationService.getConsommationById(id);
            responseDto.setResult(consommation);
        } catch (Exception ex) {
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }

        @PostMapping("/consommations")
        public ResponseDto saveConsommation(@RequestBody Consommation consommation){
            try{
                consommationService.CreateUpdateConsommation(consommation);
                responseDto.setResult(consommation);
                responseDto.setResult(consommation);
                responseDto.setDisplayMessage("Consommation added succefuly");
            }catch (Exception ex){
                responseDto.setIsSuccess(false);
                responseDto.setDisplayMessage(ex.getMessage());
                ErrorMessages.add(ex.getMessage());
                responseDto.setErrorMessages(ErrorMessages);
            }
            return responseDto;
        }
    @PutMapping("/consommations")
    public ResponseDto updateConsommation(@RequestBody Consommation consommation){
        try{
            consommationService.CreateUpdateConsommation(consommation);
            responseDto.setResult(consommation);
            responseDto.setResult(consommation);
            responseDto.setDisplayMessage("Consommation added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }

    @DeleteMapping("/consommations/{id}")
    public ResponseDto deleteConsommation(@PathVariable Long id){
        try {
            Consommation consommation =consommationService.getConsommationById(id);
            if(consommation != null) {
                consommationService.deleteConsommation(consommation);
                responseDto.setDisplayMessage("Consommation supprime");
                responseDto.setResult(consommation);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Consommation not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }




}
