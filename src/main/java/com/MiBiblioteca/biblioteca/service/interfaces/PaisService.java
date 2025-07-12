package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.PaisRequest;
import com.MiBiblioteca.biblioteca.entity.dto.PaisResponse;

public interface PaisService {

    List<PaisResponse> getAllPaises();

    PaisResponse getPaisById(Long id);

    PaisResponse createPais(PaisRequest request);

    PaisResponse updatePais(Long id, PaisRequest request);

    void deletePais(Long id);
}

