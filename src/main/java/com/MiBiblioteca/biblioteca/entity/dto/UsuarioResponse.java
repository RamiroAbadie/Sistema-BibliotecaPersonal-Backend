package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsuarioResponse {
    private Long idUsuario;
    private String nombre;
    private List<Long> librosLeidos; // Solo los ID de los libros
    private List<DeseadoResponse> listaDeseados;
}

