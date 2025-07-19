package com.MiBiblioteca.biblioteca.entity.dto;

import com.MiBiblioteca.biblioteca.enums.Sexo;

import lombok.Data;

@Data
public class AutorResponse {
    private Long idAutor;
    private String nombre;
    private Sexo sexo;
    private String pais;
}
