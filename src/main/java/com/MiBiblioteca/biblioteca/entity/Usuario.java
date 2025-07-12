package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "usuario_libro_leido",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libro> librosLeidos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Deseado> listaDeseados;
}

