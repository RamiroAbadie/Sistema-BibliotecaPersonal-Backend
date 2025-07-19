package com.MiBiblioteca.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiBiblioteca.biblioteca.entity.Genero;
import com.MiBiblioteca.biblioteca.entity.dto.GeneroRequest;
import com.MiBiblioteca.biblioteca.entity.dto.GeneroResponse;
import com.MiBiblioteca.biblioteca.repository.GeneroRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.GeneroService;

import jakarta.validation.Valid;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository GeneroRepository;

    @Override
    public List<GeneroResponse> getAllGeneros() {
        return GeneroRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public GeneroResponse getGeneroById(Long id) {
        Genero genero = GeneroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Género no encontrado"));
        return mapToResponse(genero);
    }

    @Override
    public GeneroResponse createGenero(@Valid GeneroRequest request) {
        Genero genero = new Genero();
        genero.setDescripcion(request.getDescripcion());
        return mapToResponse(GeneroRepository.save(genero));
    }

    @Override
    public GeneroResponse updateGenero(Long id, @Valid GeneroRequest request) {
        Genero genero = GeneroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Género no encontrado"));

        genero.setDescripcion(request.getDescripcion());
        return mapToResponse(GeneroRepository.save(genero));
    }

    @Override
    public void deleteGenero(Long id) {
        if (!GeneroRepository.existsById(id)) {
            throw new RuntimeException("Género no encontrado");
        }
        GeneroRepository.deleteById(id);
    }

    private GeneroResponse mapToResponse(Genero genero) {
        GeneroResponse dto = new GeneroResponse();
        dto.setIdGenero(genero.getIdGenero());
        dto.setDescripcion(genero.getDescripcion());
        return dto;
    }
}

