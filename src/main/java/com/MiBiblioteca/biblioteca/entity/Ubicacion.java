package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    @Column(nullable = false)
    private String referencia;

    @OneToMany(mappedBy = "ubicacion")
    private List<Libro> libros;
}
