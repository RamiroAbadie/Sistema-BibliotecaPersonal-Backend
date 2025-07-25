package com.MiBiblioteca.biblioteca.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.PaisRequest;
import com.MiBiblioteca.biblioteca.entity.dto.PaisResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.PaisService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService paisService;

    @GetMapping
    public List<PaisResponse> getAllPaises() {
        return paisService.getAllPaises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisResponse> getPaisById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(paisService.getPaisById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PaisResponse> createPais(@Valid @RequestBody PaisRequest request) {
        return ResponseEntity.ok(paisService.createPais(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisResponse> updatePais(@PathVariable Long id, @Valid @RequestBody PaisRequest request) {
        return ResponseEntity.ok(paisService.updatePais(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.noContent().build();
    }
}

