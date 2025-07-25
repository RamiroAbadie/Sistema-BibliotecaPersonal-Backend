package com.MiBiblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MiBiblioteca.biblioteca.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}

