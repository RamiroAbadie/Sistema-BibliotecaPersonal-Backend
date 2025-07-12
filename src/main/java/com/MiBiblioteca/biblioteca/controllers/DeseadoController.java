package com.MiBiblioteca.biblioteca.controllers;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.DeseadoRequest;
import com.MiBiblioteca.biblioteca.entity.dto.DeseadoResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.DeseadoService;

@RestController
@RequestMapping("/api/deseados")
@RequiredArgsConstructor
public class DeseadoController {

    private final DeseadoService deseadoService;

    @GetMapping
    public List<DeseadoResponse> getAllDeseados() {
        return deseadoService.getAllDeseados();
    }

    @PostMapping("/{idUsuario}")
    public DeseadoResponse agregarDeseado(
            @PathVariable Long idUsuario,
            @RequestBody DeseadoRequest request) {
        return deseadoService.agregarDeseado(idUsuario, request);
    }

    @DeleteMapping("/{idDeseado}")
    public void eliminarDeseado(@PathVariable Long idDeseado) {
        deseadoService.eliminarDeseado(idDeseado);
    }
}

