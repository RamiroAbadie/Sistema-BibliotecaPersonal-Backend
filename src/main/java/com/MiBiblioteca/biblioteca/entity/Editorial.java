package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idPais", nullable = false)
    private Pais pais;

    @ManyToMany(mappedBy = "editoriales")
    private List<Libro> libros;
}

