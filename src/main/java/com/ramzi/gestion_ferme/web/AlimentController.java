package com.ramzi.gestion_ferme.web;

import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.*;
import com.ramzi.gestion_ferme.services.AlimentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AlimentController {
    final private AlimentService alimentService;
    final ResponseDto responseDto = new ResponseDto();
    public List<String> ErrorMessages;

    public AlimentController(AlimentService alimentService){
        this.alimentService = alimentService;
    }

    @GetMapping("/aliments")
    public ResponseDto listAliment(){
        try{
            List<Aliment> aliments = alimentService.getAllAliment();
            responseDto.setResult(aliments);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }

    @GetMapping("/aliments/{id}")
    public ResponseDto alimentById(@PathVariable Long id){
        try{
            Aliment aliment = alimentService.getAlimentById(id);
            responseDto.setResult(aliment);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PostMapping("/aliments")
    public ResponseDto saveAliment(@RequestBody Aliment aliment){
        try{
            alimentService.CreateUpdateAliment(aliment);
            responseDto.setResult(aliment);
            responseDto.setResult(aliment);
            responseDto.setDisplayMessage("Aliment added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PutMapping("/aliments")
    public ResponseDto updateAliment(@RequestBody Aliment aliment){
        try{
            alimentService.CreateUpdateAliment(aliment);
            responseDto.setResult(aliment);
            responseDto.setResult(aliment);
            responseDto.setDisplayMessage("Aliment added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @DeleteMapping("/aliments/{id}")
    public ResponseDto deleteAliment(@PathVariable Long id){
        try {
            Aliment aliment = alimentService.getAlimentById(id);
            if(aliment != null) {
                alimentService.deleteAliment(aliment);
                responseDto.setDisplayMessage("Aliment supprime");
                responseDto.setResult(aliment);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Aliment not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }
}
