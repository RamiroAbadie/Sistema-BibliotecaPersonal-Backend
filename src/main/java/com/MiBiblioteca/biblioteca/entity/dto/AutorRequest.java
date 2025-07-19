package com.MiBiblioteca.biblioteca.entity.dto;

import com.MiBiblioteca.biblioteca.enums.Sexo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AutorRequest {
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El sexo es obligatorio")
    private Sexo sexo;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El paisId es obligatorio")
    private Long paisId;
}

