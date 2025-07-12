package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.LibroRequest;
import com.MiBiblioteca.biblioteca.entity.dto.LibroResponse;

public interface LibroService {

    List<LibroResponse> getAllLibros();

    LibroResponse getLibroById(Long id);

    LibroResponse createLibro(LibroRequest dto);

    LibroResponse updateLibro(Long id, LibroRequest dto);

    void deleteLibro(Long id);
}
