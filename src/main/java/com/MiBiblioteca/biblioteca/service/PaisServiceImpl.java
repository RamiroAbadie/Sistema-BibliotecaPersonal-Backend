package com.MiBiblioteca.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiBiblioteca.biblioteca.entity.Pais;
import com.MiBiblioteca.biblioteca.entity.dto.PaisRequest;
import com.MiBiblioteca.biblioteca.entity.dto.PaisResponse;
import com.MiBiblioteca.biblioteca.repository.PaisRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.PaisService;

import jakarta.validation.Valid;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    @Override
    public List<PaisResponse> getAllPaises() {
        return paisRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public PaisResponse getPaisById(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        return mapToResponse(pais);
    }

    @Override
    public PaisResponse createPais(@Valid PaisRequest request) {
        Pais pais = new Pais();
        pais.setNombre(request.getNombre());
        return mapToResponse(paisRepository.save(pais));
    }

    @Override
    public PaisResponse updatePais(Long id, @Valid PaisRequest request) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));

        pais.setNombre(request.getNombre());
        return mapToResponse(paisRepository.save(pais));
    }

    @Override
    public void deletePais(Long id) {
        if (!paisRepository.existsById(id)) {
            throw new RuntimeException("País no encontrado");
        }
        paisRepository.deleteById(id);
    }

    private PaisResponse mapToResponse(Pais pais) {
        PaisResponse dto = new PaisResponse();
        dto.setIdPais(pais.getIdPais());
        dto.setNombre(pais.getNombre());
        return dto;
    }
}
