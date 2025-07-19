package com.MiBiblioteca.biblioteca.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GeneroRequest {
    @NotNull(message = "La descripcion no puede ser nula")
    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;
}

