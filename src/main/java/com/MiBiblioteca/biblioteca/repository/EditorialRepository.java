package com.MiBiblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MiBiblioteca.biblioteca.entity.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
}

