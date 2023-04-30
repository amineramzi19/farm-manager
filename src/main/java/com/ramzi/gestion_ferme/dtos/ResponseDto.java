package com.ramzi.gestion_ferme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ResponseDto {
    private boolean IsSuccess = true;
    private Object Result;
    public String DisplayMessage;
    public List<String> ErrorMessages;
}
