package com.MiBiblioteca.biblioteca.service.interfaces;

import java.util.List;

import com.MiBiblioteca.biblioteca.entity.dto.EditorialRequest;
import com.MiBiblioteca.biblioteca.entity.dto.EditorialResponse;

public interface EditorialService {

    List<EditorialResponse> getAllEditoriales();

    EditorialResponse getEditorialById(Long id);

    EditorialResponse createEditorial(EditorialRequest request);

    EditorialResponse updateEditorial(Long id, EditorialRequest request);

    void deleteEditorial(Long id);
}

