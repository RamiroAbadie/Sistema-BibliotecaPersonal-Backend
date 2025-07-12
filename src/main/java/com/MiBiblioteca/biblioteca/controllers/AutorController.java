package com.MiBiblioteca.biblioteca.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.AutorRequest;
import com.MiBiblioteca.biblioteca.entity.dto.AutorResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.AutorService;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public List<AutorResponse> getAllAutores() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> getAutorById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(autorService.getAutorById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AutorResponse> createAutor(@RequestBody AutorRequest request) {
        return ResponseEntity.ok(autorService.createAutor(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> updateAutor(@PathVariable Long id, @RequestBody AutorRequest request) {
        return ResponseEntity.ok(autorService.updateAutor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}

