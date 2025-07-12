package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "pais")
    private List<Autor> autores;

    @OneToMany(mappedBy = "pais")
    private List<Editorial> editoriales;
}

