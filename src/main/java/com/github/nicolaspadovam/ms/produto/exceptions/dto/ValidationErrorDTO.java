package com.github.nicolaspadovam.ms.produto.exceptions.dto;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO extends CustomErrorDTO {


    private List<FieldMessageDTO> errors = new ArrayList<>();

    //Construtor
    public ValidationErrorDTO(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }


    //metodo para adicionar erros a List
    public void addError(String fieldName, String message) {
        //remove o error do campo duplicado
        errors.removeIf(x -> x.getFieldName().equals(fieldName));

        errors.add(new FieldMessageDTO(fieldName, message));
    }


}
