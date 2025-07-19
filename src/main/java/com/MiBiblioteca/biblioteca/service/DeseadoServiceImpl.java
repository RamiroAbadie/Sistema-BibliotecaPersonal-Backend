package com.MiBiblioteca.biblioteca.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.MiBiblioteca.biblioteca.entity.Deseado;
import com.MiBiblioteca.biblioteca.entity.Usuario;
import com.MiBiblioteca.biblioteca.entity.dto.DeseadoRequest;
import com.MiBiblioteca.biblioteca.entity.dto.DeseadoResponse;
import com.MiBiblioteca.biblioteca.repository.DeseadoRepository;
import com.MiBiblioteca.biblioteca.repository.UsuarioRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.DeseadoService;

@Service
@RequiredArgsConstructor
@Transactional
public class DeseadoServiceImpl implements DeseadoService {

    private final DeseadoRepository deseadoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<DeseadoResponse> getAllDeseados() {
        return deseadoRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DeseadoResponse agregarDeseado(Long idUsuario, @Valid DeseadoRequest request) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Deseado deseado = new Deseado();
        deseado.setTitulo(request.getTitulo());
        deseado.setAutor(request.getAutor());
        deseado.setUsuario(usuario);

        deseadoRepository.save(deseado);

        return mapToDto(deseado);
    }

    @Override
    public void eliminarDeseado(Long idDeseado) {
        deseadoRepository.deleteById(idDeseado);
    }

    private DeseadoResponse mapToDto(Deseado deseado) {
        DeseadoResponse response = new DeseadoResponse();
        response.setIdDeseado(deseado.getIdDeseado());
        response.setTitulo(deseado.getTitulo());
        response.setAutor(deseado.getAutor());
        response.setUsuario(deseado.getUsuario().getNombre());
        
        return response;
    }
}

