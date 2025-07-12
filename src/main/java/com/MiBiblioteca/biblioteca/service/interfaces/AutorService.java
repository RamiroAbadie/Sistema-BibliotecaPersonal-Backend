package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.AutorRequest;
import com.MiBiblioteca.biblioteca.entity.dto.AutorResponse;

public interface AutorService {

    List<AutorResponse> getAllAutores();

    AutorResponse getAutorById(Long id);

    AutorResponse createAutor(AutorRequest request);

    AutorResponse updateAutor(Long id, AutorRequest request);

    void deleteAutor(Long id);
}

