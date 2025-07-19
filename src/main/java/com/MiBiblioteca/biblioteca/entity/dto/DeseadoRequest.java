package com.MiBiblioteca.biblioteca.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeseadoRequest {
    @NotBlank(message = "El titulo no puede estar vacio")
    @NotNull(message = "El titulo no puede ser nulo")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacio")
    @NotNull(message = "El autor no puede ser nulo")
    private String autor;
}

