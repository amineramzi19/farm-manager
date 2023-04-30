package com.ramzi.gestion_ferme.web;


import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.Pesee;
import com.ramzi.gestion_ferme.services.PeseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeseeController {
    @Autowired
    private PeseeService peseeService;
    private final ResponseDto responseDto = new ResponseDto();
    public List<String> ErrorMessages;

    @GetMapping("/pesees")
    public ResponseDto listPesee(){
        try{
            List<Pesee>pesees = peseeService.getAllPesee();
            responseDto.setResult(pesees);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @GetMapping("/peses/{id}")
    public ResponseDto pesseById(@PathVariable Long id){
        try{
            Pesee pesse = peseeService.getPeseeById(id);
            responseDto.setResult(pesse);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PostMapping("/pesees")
    public ResponseDto savePesse(@RequestBody Pesee pesee){
        try{
            peseeService.CreateUpdatePesee(pesee);
            responseDto.setResult(pesee);
            responseDto.setResult(pesee);
            responseDto.setDisplayMessage("Pesee added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PutMapping("/pesees")
    public ResponseDto updatePesee(@RequestBody Pesee pesee){
        try{
            peseeService.CreateUpdatePesee(pesee);
            responseDto.setResult(pesee);
            responseDto.setResult(pesee);
            responseDto.setDisplayMessage("Pesee added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @DeleteMapping("/pesees/{id}")
    public ResponseDto deletePesee(@PathVariable Long id){
        try {
            Pesee pesee =peseeService.getPeseeById(id);
            if(pesee != null) {
                peseeService.deletePesee(pesee);
                responseDto.setDisplayMessage("Pesee supprime");
                responseDto.setResult(pesee);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Pesee not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }


}
