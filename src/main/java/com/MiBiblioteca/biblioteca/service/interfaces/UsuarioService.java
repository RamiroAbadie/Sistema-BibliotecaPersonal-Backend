package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.UsuarioRequest;
import com.MiBiblioteca.biblioteca.entity.dto.UsuarioResponse;

public interface UsuarioService {

    UsuarioResponse crearUsuario(UsuarioRequest request);

    List<UsuarioResponse> getAllUsuarios();

    UsuarioResponse obtenerPorId(Long id);

    UsuarioResponse marcarLibroLeido(Long idUsuario, Long idLibro);

    UsuarioResponse quitarLibroLeido(Long idUsuario, Long idLibro);
}

