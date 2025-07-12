package com.MiBiblioteca.biblioteca.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.MiBiblioteca.biblioteca.entity.dto.UsuarioRequest;
import com.MiBiblioteca.biblioteca.entity.dto.UsuarioResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponse crearUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.crearUsuario(request);
    }

    @GetMapping
    public List<UsuarioResponse> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioResponse obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping("/{id}/leidos/{idLibro}")
    public UsuarioResponse marcarLibroLeido(@PathVariable Long id, @PathVariable Long idLibro) {
        return usuarioService.marcarLibroLeido(id, idLibro);
    }

    @DeleteMapping("/{id}/leidos/{idLibro}")
    public UsuarioResponse quitarLibroLeido(@PathVariable Long id, @PathVariable Long idLibro) {
        return usuarioService.quitarLibroLeido(id, idLibro);
    }
}

