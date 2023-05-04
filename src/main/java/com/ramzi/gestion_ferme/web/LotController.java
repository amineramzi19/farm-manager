package com.ramzi.gestion_ferme.web;

import com.ramzi.gestion_ferme.dtos.ResponseDto;
import com.ramzi.gestion_ferme.entities.Lot;
import com.ramzi.gestion_ferme.services.Implementation.LotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LotController {
    final private LotService lotService;
    final ResponseDto responseDto= new ResponseDto();
    public List<String>ErrorMessages;

    public LotController(LotService lotService) {
        this.lotService = lotService;
    }


    @GetMapping("/lots")
    public ResponseDto listLot(){
        try{
            List<Lot> lots = lotService.getAllLot();
            responseDto.setResult(lots);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @GetMapping("/lots/{id}")
    public ResponseDto lotById(@PathVariable Long id){
        try{
            Lot lot= lotService.getLotById(id);
            responseDto.setResult(lot);
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PostMapping("/lots")
    public ResponseDto savelot(@RequestBody Lot lot){
        try{
            lotService.CreateUpdateLot(lot);
            responseDto.setResult(lot);
            responseDto.setResult(lot);
            responseDto.setDisplayMessage("lot added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @PutMapping("/lots")
    public ResponseDto updateLot(@RequestBody Lot lot){
        try{
            lotService.CreateUpdateLot(lot);
            responseDto.setResult(lot);
            responseDto.setResult(lot);
            responseDto.setDisplayMessage("Lot added succefuly");
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage(ex.getMessage());
            ErrorMessages.add(ex.getMessage());
            responseDto.setErrorMessages(ErrorMessages);
        }
        return responseDto;
    }
    @DeleteMapping("/lots/{id}")
    public ResponseDto deleteLot(@PathVariable Long id){
        try {
            Lot lot =lotService.getLotById(id);
            if(lot != null) {
                lotService.deleteLot(lot);
                responseDto.setDisplayMessage("lot supprime");
                responseDto.setResult(lot);
            }
        }catch (Exception ex){
            responseDto.setIsSuccess(false);
            responseDto.setDisplayMessage("Lot not existe");
            responseDto.setResult(null);
        }
        return responseDto;
    }




}
