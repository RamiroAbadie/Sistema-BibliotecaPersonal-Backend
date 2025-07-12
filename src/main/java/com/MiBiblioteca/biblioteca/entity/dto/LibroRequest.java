package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibroRequest {

    private String titulo;
    private Integer paginas;

    private Long ubicacionId;

    private List<Long> autoresIds;
    private List<Long> generosIds;
    private List<Long> editorialesIds;

}

