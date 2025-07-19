package com.MiBiblioteca.biblioteca.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditorialRequest {
    @NotBlank(message = "El nombre no puede estar vacio")
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @NotBlank(message = "El paisId no puede estar vacio")
    @NotNull(message = "El paisId no puede ser nulo")
    private Long paisId;  // FK con País
}

