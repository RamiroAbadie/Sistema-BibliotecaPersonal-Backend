package com.MiBiblioteca.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiBiblioteca.biblioteca.entity.Editorial;
import com.MiBiblioteca.biblioteca.entity.dto.EditorialRequest;
import com.MiBiblioteca.biblioteca.entity.dto.EditorialResponse;
import com.MiBiblioteca.biblioteca.repository.EditorialRepository;
import com.MiBiblioteca.biblioteca.repository.PaisRepository;
import com.MiBiblioteca.biblioteca.service.interfaces.EditorialService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EditorialServiceImpl implements EditorialService {

    private final EditorialRepository EditorialRepository;
    private final PaisRepository paisRepository;

    @Override
    public List<EditorialResponse> getAllEditoriales() {
        return EditorialRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EditorialResponse getEditorialById(Long id) {
        Editorial editorial = EditorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
        return mapToResponse(editorial);
    }

    @Override
    public EditorialResponse createEditorial(EditorialRequest request) {
        Editorial editorial = new Editorial();
        editorial.setNombre(request.getNombre());

        if (request.getPaisId() != null) {
            var pais = paisRepository.findById(request.getPaisId())
                    .orElseThrow(() -> new RuntimeException("País no encontrado"));
            editorial.setPais(pais);
        }

        return mapToResponse(EditorialRepository.save(editorial));
    }

    @Override
    public EditorialResponse updateEditorial(Long id, EditorialRequest request) {
        Editorial editorial = EditorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        editorial.setNombre(request.getNombre());

        if (request.getPaisId() != null) {
            var pais = paisRepository.findById(request.getPaisId())
                    .orElseThrow(() -> new RuntimeException("País no encontrado"));
            editorial.setPais(pais);
        }

        return mapToResponse(EditorialRepository.save(editorial));
    }

    @Override
    public void deleteEditorial(Long id) {
        if (!EditorialRepository.existsById(id)) {
            throw new RuntimeException("Editorial no encontrada");
        }
        EditorialRepository.deleteById(id);
    }

    private EditorialResponse mapToResponse(Editorial editorial) {
        EditorialResponse dto = new EditorialResponse();
        dto.setIdEditorial(editorial.getIdEditorial());
        dto.setNombre(editorial.getNombre());
        dto.setPais(editorial.getPais() != null ? editorial.getPais().getNombre() : null);
        return dto;
    }
}
