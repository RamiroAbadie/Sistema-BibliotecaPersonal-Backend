package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @Column(nullable = false)
    private String titulo;

    @Column
    private Integer paginas;

    @ManyToOne
    @JoinColumn(name = "idUbicacion", nullable = false)
    private Ubicacion ubicacion;

    @ManyToMany
    @JoinTable(
        name = "Libro_Autor",
        joinColumns = @JoinColumn(name = "idLibro"),
        inverseJoinColumns = @JoinColumn(name = "idAutor")
    )
    private List<Autor> autores;

    @ManyToMany
    @JoinTable(
        name = "Libro_Genero",
        joinColumns = @JoinColumn(name = "idLibro"),
        inverseJoinColumns = @JoinColumn(name = "idGenero")
    )
    private List<Genero> generos;

    @ManyToMany
    @JoinTable(
        name = "Libro_Editorial",
        joinColumns = @JoinColumn(name = "idLibro"),
        inverseJoinColumns = @JoinColumn(name = "idEditorial")
    )
    private List<Editorial> editoriales;
}
