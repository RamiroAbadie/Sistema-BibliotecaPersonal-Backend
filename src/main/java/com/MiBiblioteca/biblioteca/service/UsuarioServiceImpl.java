package com.MiBiblioteca.biblioteca.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.MiBiblioteca.biblioteca.entity.Libro;
import com.MiBiblioteca.biblioteca.entity.Usuario;
import com.MiBiblioteca.biblioteca.entity.dto.DeseadoResponse;
import com.MiBiblioteca.biblioteca.entity.dto.UsuarioRequest;
import com.MiBiblioteca.biblioteca.entity.dto.UsuarioResponse;
import com.MiBiblioteca.biblioteca.repository.LibroRepository;
import com.MiBiblioteca.biblioteca.repository.UsuarioRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LibroRepository libroRepository;

    @Override
    public UsuarioResponse crearUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setLibrosLeidos(new ArrayList<>());
        usuario.setListaDeseados(new ArrayList<>());

        Usuario guardado = usuarioRepository.save(usuario);
        return mapToDto(guardado);
    }

    @Override
    public List<UsuarioResponse> getAllUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapToDto(usuario);
    }

    @Override
    public UsuarioResponse marcarLibroLeido(Long idUsuario, Long idLibro) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libro libro = libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        if (!usuario.getLibrosLeidos().contains(libro)) {
            usuario.getLibrosLeidos().add(libro);
        }

        return mapToDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponse quitarLibroLeido(Long idUsuario, Long idLibro) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libro libro = libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        usuario.getLibrosLeidos().remove(libro);

        return mapToDto(usuarioRepository.save(usuario));
    }

    private UsuarioResponse mapToDto(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setIdUsuario(usuario.getIdUsuario());
        response.setNombre(usuario.getNombre());
        response.setLibrosLeidos(
                usuario.getLibrosLeidos()
                        .stream()
                        .map(Libro::getIdLibro)
                        .collect(Collectors.toList())
        );
        response.setListaDeseados(
                usuario.getListaDeseados()
                        .stream()
                        .map(d -> {
                            DeseadoResponse dr = new DeseadoResponse();
                            dr.setIdDeseado(d.getIdDeseado());
                            dr.setTitulo(d.getTitulo());
                            dr.setAutor(d.getAutor());
                            return dr;
                        }).collect(Collectors.toList())
        );
        return response;
    }
}

