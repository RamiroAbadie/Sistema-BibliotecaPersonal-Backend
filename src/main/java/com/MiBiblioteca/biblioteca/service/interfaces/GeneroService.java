package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.GeneroRequest;
import com.MiBiblioteca.biblioteca.entity.dto.GeneroResponse;

public interface GeneroService {

    List<GeneroResponse> getAllGeneros();

    GeneroResponse getGeneroById(Long id);

    GeneroResponse createGenero(GeneroRequest request);

    GeneroResponse updateGenero(Long id, GeneroRequest request);

    void deleteGenero(Long id);
}

