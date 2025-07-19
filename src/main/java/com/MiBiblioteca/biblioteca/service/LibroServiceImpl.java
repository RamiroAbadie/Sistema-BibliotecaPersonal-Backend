package com.MiBiblioteca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.MiBiblioteca.biblioteca.entity.Autor;
import com.MiBiblioteca.biblioteca.entity.Editorial;
import com.MiBiblioteca.biblioteca.entity.Genero;
import com.MiBiblioteca.biblioteca.entity.Libro;
import com.MiBiblioteca.biblioteca.entity.Ubicacion;
import com.MiBiblioteca.biblioteca.entity.dto.LibroRequest;
import com.MiBiblioteca.biblioteca.entity.dto.LibroResponse;
import com.MiBiblioteca.biblioteca.repository.*;
import com.MiBiblioteca.biblioteca.service.interfaces.LibroService;

@Service
@Transactional
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    @Autowired //Creo que igual no hace falta por el @RequiredArgsConstructor
    private final LibroRepository libroRepository;
    private final UbicacionRepository ubicacionRepository;
    private final AutorRepository autorRepository;
    private final GeneroRepository generoRepository;
    private final EditorialRepository editorialRepository;

    @Override
    public List<LibroResponse> getAllLibros() {
        return libroRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public LibroResponse getLibroById(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return mapToResponse(libro);
    }

    @Override
    public LibroResponse createLibro(@Valid LibroRequest dto) {
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());

        libro.setPaginas(dto.getPaginas());

        Ubicacion ubicacion = ubicacionRepository.findById(dto.getUbicacionId())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
        libro.setUbicacion(ubicacion);

        List<Autor> autores = autorRepository.findAllById(dto.getAutoresIds());
        libro.setAutores(autores);

        List<Genero> generos = generoRepository.findAllById(dto.getGenerosIds());
        libro.setGeneros(generos);

        List<Editorial> Editorial = editorialRepository.findAllById(dto.getEditorialesIds());
        libro.setEditoriales(Editorial);

        Libro guardado = libroRepository.save(libro);
        return mapToResponse(guardado);
    }

    @Override
    public LibroResponse updateLibro(Long id, @Valid LibroRequest dto) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libro.setTitulo(dto.getTitulo());

        libro.setPaginas(dto.getPaginas());

        Ubicacion ubicacion = ubicacionRepository.findById(dto.getUbicacionId())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
        libro.setUbicacion(ubicacion);

        libro.setAutores(autorRepository.findAllById(dto.getAutoresIds()));

        libro.setGeneros(generoRepository.findAllById(dto.getGenerosIds()));

        libro.setEditoriales(editorialRepository.findAllById(dto.getEditorialesIds()));


        Libro actualizado = libroRepository.save(libro);
        return mapToResponse(actualizado);
    }

    @Override
    public void deleteLibro(Long id) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.deleteById(id);
    }

    private LibroResponse mapToResponse(Libro libro) {
        LibroResponse dto = new LibroResponse();
        dto.setIdLibro(libro.getIdLibro());
        dto.setTitulo(libro.getTitulo());
        dto.setPaginas(libro.getPaginas());
        dto.setUbicacion(libro.getUbicacion() != null ? libro.getUbicacion().getReferencia() : null);
        dto.setAutores(libro.getAutores() != null ?
                libro.getAutores().stream().map(a -> a.getNombre()).toList() : null);
        dto.setGeneros(libro.getGeneros() != null ?
                libro.getGeneros().stream().map(g -> g.getDescripcion()).toList() : null);
        dto.setEditoriales(libro.getEditoriales() != null ?
                libro.getEditoriales().stream().map(e -> e.getNombre()).toList() : null);
        return dto;
    }
}
