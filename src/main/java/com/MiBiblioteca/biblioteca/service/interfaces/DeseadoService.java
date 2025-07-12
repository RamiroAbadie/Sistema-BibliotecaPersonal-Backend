package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.DeseadoRequest;
import com.MiBiblioteca.biblioteca.entity.dto.DeseadoResponse;

public interface DeseadoService {
    List<DeseadoResponse> getAllDeseados();

    DeseadoResponse agregarDeseado(Long idUsuario, DeseadoRequest request);

    void eliminarDeseado(Long idDeseado);
}

