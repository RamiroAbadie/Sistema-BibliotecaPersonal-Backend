package com.MiBiblioteca.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiBiblioteca.biblioteca.entity.Ubicacion;
import com.MiBiblioteca.biblioteca.entity.dto.UbicacionResponse;
import com.MiBiblioteca.biblioteca.repository.UbicacionRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.UbicacionService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UbicacionServiceImpl implements UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    @Override
    public List<UbicacionResponse> getAllUbicaciones() {
        return ubicacionRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public UbicacionResponse getUbicacionById(Long id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
        return mapToResponse(ubicacion);
    }

    private UbicacionResponse mapToResponse(Ubicacion ubicacion) {
        UbicacionResponse dto = new UbicacionResponse();
        dto.setIdUbicacion(ubicacion.getIdUbicacion());
        dto.setReferencia(ubicacion.getReferencia());
        return dto;
    }
}

