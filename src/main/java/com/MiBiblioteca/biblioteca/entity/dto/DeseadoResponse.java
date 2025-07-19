package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

@Data
public class DeseadoResponse {
    private Long idDeseado;
    private String titulo;
    private String autor;
    private String usuario; //Quien agrego el libro a deseados
}

