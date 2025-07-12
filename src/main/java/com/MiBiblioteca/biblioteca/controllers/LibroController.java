package com.MiBiblioteca.biblioteca.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.LibroRequest;
import com.MiBiblioteca.biblioteca.entity.dto.LibroResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.LibroService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @GetMapping
    public List<LibroResponse> getAllLibros() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> getLibroById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(libroService.getLibroById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LibroResponse> createLibro(@RequestBody LibroRequest request) {
        return ResponseEntity.ok(libroService.createLibro(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponse> updateLibro(@PathVariable Long id, @RequestBody LibroRequest request) {
        return ResponseEntity.ok(libroService.updateLibro(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }
}

