package com.MiBiblioteca.biblioteca.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.UbicacionResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.UbicacionService;

import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    @GetMapping
    public List<UbicacionResponse> getAllUbicaciones() {
        return ubicacionService.getAllUbicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionResponse> getUbicacionById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ubicacionService.getUbicacionById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}

