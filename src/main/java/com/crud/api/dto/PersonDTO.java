package com.crud.api.dto;

import java.util.Date;

import jakarta.validation.constraints.*;

public record PersonDTO (
    
    @NotBlank
    @NotNull
    String name,

    @NotBlank
    @NotNull
    String lastname,

    @Past
    @NotBlank
    Date birthdate,

    @Pattern (regexp = "\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}") @NotNull
    String phone,

    @NotBlank
    @NotNull
    @Email
    String email
   
){
    
}
