package com.MiBiblioteca.biblioteca.entity;

import jakarta.persistence.GenerationType;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Deseado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeseado;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String autor; // Opcional

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
