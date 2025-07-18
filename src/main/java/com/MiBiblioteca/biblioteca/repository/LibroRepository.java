package com.MiBiblioteca.biblioteca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MiBiblioteca.biblioteca.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    
}
