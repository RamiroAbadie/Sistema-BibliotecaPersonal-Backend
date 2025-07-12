package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibroResponse {

    private Long idLibro;
    private String titulo;
    private Integer paginas;

    private String ubicacion;

    private List<String> autores;
    private List<String> generos;
    private List<String> editoriales;

}

