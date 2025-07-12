package com.MiBiblioteca.biblioteca.entity.dto;

import lombok.Data;

@Data
public class EditorialRequest {
    private String nombre;
    private Long paisId;  // FK con País
}

