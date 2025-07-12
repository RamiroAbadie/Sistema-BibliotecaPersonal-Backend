package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

@Data
public class AutorResponse {
    private Long idAutor;
    private String nombre;
    private String sexo;
    private String pais;
}
