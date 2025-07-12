package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "idPais", nullable = false)
    private Pais pais;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
}
