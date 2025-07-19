package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.MiBiblioteca.biblioteca.enums.Sexo;

@Data
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column
    private Sexo sexo; // puede ser null (Solo para autor "Sin autor")

    @ManyToOne
    @JoinColumn(name = "idPais", nullable = false)
    private Pais pais;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
}
