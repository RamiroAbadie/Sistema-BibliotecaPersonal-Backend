package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsuarioResponse {
    private Long idUsuario;
    private String nombre;
    private List<LibroResponse> librosLeidos;
    private List<DeseadoResponse> listaDeseados;
}

