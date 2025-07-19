package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class LibroRequest {
    @NotBlank(message = "El titulo no puede estar vacio")
    @NotNull(message = "El titulo no puede ser nulo")
    private String titulo;

    @NotBlank(message = "Las paginas no pueden estar vacias")
    @NotNull(message = "Las paginas no puede ser nulo")
    private Integer paginas;

    @NotBlank(message = "La ubicacionId no puede estar vacia")
    @NotNull(message = "La ubicacionId no puede ser nulo")
    private Long ubicacionId;

    @NotBlank(message = "Los autoresIds no pueden estar vacios")
    @NotNull(message = "Los autoresIds no pueden ser nulo")
    private List<Long> autoresIds;

    @NotBlank(message = "Los generosIds no pueden estar vacios")
    @NotNull(message = "Los generosIds no pueden ser nulo")
    private List<Long> generosIds;

    @NotBlank(message = "Los editorialesIds no pueden estar vacios")
    @NotNull(message = "Las editorialesIds no pueden ser nulo")
    private List<Long> editorialesIds;

}

