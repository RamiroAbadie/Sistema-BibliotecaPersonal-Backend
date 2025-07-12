package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.UbicacionResponse;

public interface UbicacionService {

    List<UbicacionResponse> getAllUbicaciones();

    UbicacionResponse getUbicacionById(Long id);
}
