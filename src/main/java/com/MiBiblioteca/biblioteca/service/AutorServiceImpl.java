package com.MiBiblioteca.biblioteca.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiBiblioteca.biblioteca.entity.Autor;
import com.MiBiblioteca.biblioteca.entity.dto.AutorRequest;
import com.MiBiblioteca.biblioteca.entity.dto.AutorResponse;
import com.MiBiblioteca.biblioteca.repository.AutorRepository;
import com.MiBiblioteca.biblioteca.repository.PaisRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.AutorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

    private final AutorRepository AutorRepository;
    private final PaisRepository paisRepository;

    @Override
    public List<AutorResponse> getAllAutores() {
        return AutorRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public AutorResponse getAutorById(Long id) {
        Autor autor = AutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        return mapToResponse(autor);
    }

    @Override
    public AutorResponse createAutor(AutorRequest request) {
        Autor autor = new Autor();
        autor.setNombre(request.getNombre());
        autor.setSexo(request.getSexo());

        if (request.getPaisId() != null) {
            var pais = paisRepository.findById(request.getPaisId())
                    .orElseThrow(() -> new RuntimeException("País no encontrado"));
            autor.setPais(pais);
        }

        return mapToResponse(AutorRepository.save(autor));
    }

    @Override
    public AutorResponse updateAutor(Long id, AutorRequest request) {
        Autor autor = AutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        autor.setNombre(request.getNombre());
        autor.setSexo(request.getSexo());

        if (request.getPaisId() != null) {
            var pais = paisRepository.findById(request.getPaisId())
                    .orElseThrow(() -> new RuntimeException("País no encontrado"));
            autor.setPais(pais);
        }

        return mapToResponse(AutorRepository.save(autor));
    }

    @Override
    public void deleteAutor(Long id) {
        if (!AutorRepository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado");
        }
        AutorRepository.deleteById(id);
    }

    private AutorResponse mapToResponse(Autor autor) {
        AutorResponse response = new AutorResponse();
        response.setIdAutor(autor.getIdAutor());
        response.setNombre(autor.getNombre());
        response.setSexo(autor.getSexo());
        response.setPais(autor.getPais() != null ? autor.getPais().getNombre() : null);
        return response;
    }
}

