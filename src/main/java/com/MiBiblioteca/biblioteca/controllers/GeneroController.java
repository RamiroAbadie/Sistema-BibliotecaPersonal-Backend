package com.MiBiblioteca.biblioteca.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.GeneroRequest;
import com.MiBiblioteca.biblioteca.entity.dto.GeneroResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.GeneroService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    public List<GeneroResponse> getAllGeneros() {
        return generoService.getAllGeneros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroResponse> getGeneroById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(generoService.getGeneroById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<GeneroResponse> createGenero(@Valid @RequestBody GeneroRequest request) {
        return ResponseEntity.ok(generoService.createGenero(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroResponse> updateGenero(@PathVariable Long id, @Valid @RequestBody GeneroRequest request) {
        return ResponseEntity.ok(generoService.updateGenero(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        generoService.deleteGenero(id);
        return ResponseEntity.noContent().build();
    }
}
