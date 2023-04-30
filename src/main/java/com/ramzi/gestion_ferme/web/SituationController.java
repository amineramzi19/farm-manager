package com.ramzi.gestion_ferme.web;

import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.Situation;
import com.ramzi.gestion_ferme.services.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SituationController {
    @Autowired
    private SituationService situationService;
    private ResponseDto responseDto = new ResponseDto();
    public List<String> ErrorMessages;

    @GetMapping("/situations")
    public ResponseDto listSituation(){
        try{
            List<Situation> situations = situationService.getAllSituation();
            responseDto.setResult(situations);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @GetMapping("/situations/{id}")
    public ResponseDto situationById(@PathVariable Long id){
        try{
            Situation situation = situationService.getSituationById(id);
            responseDto.setResult(situation);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PostMapping("/situations")
    public ResponseDto saveSituation(@RequestBody Situation situation){
        try{
            situationService.CreateUpdateSituation(situation);
            responseDto.setResult(situation);
            responseDto.setResult(situation);
            responseDto.setDisplayMessage("Situation added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PutMapping("situations")
    public ResponseDto updateSituation(@RequestBody Situation situation){
        try{
            situationService.CreateUpdateSituation(situation);
            responseDto.setResult(situation);
            responseDto.setResult(situation);
            responseDto.setDisplayMessage("Situation added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @DeleteMapping("/situations/{id}")
    public ResponseDto deletesStuation(@PathVariable Long id){
        try {
            Situation situation = situationService.getSituationById(id);
            if(situation != null) {
                situationService.deleteSituation(situation);
                responseDto.setDisplayMessage("Situation supprime");
                responseDto.setResult(situation);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Situation not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }
}
