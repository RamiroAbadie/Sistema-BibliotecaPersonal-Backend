package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class LibroRequest {
    @NotBlank(message = "El titulo no puede estar vacio")
    @NotNull(message = "El titulo no puede ser nulo")
    private String titulo;

    @Positive
    @NotNull(message = "Las paginas no puede ser nulo")
    private Integer paginas;

    @Positive
    @NotNull(message = "La ubicacionId no puede ser nulo")
    private Long ubicacionId;

    @NotEmpty(message = "Los autoresIds no pueden estar vacios")
    @NotNull(message = "Los autoresIds no pueden ser nulo")
    private List<Long> autoresIds;

    @NotEmpty(message = "Los generosIds no pueden estar vacios")
    @NotNull(message = "Los generosIds no pueden ser nulo")
    private List<Long> generosIds;

    @NotEmpty(message = "Los editorialesIds no pueden estar vacios")
    @NotNull(message = "Las editorialesIds no pueden ser nulo")
    private List<Long> editorialesIds;

}

