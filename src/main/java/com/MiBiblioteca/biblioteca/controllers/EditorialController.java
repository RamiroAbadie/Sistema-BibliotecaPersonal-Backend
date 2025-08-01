package com.MiBiblioteca.biblioteca.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.MiBiblioteca.biblioteca.entity.dto.EditorialRequest;
import com.MiBiblioteca.biblioteca.entity.dto.EditorialResponse;
import com.MiBiblioteca.biblioteca.service.interfaces.EditorialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/editoriales")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EditorialController {

    private final EditorialService editorialService;

    @GetMapping
    public List<EditorialResponse> getAllEditoriales() {
        return editorialService.getAllEditoriales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorialResponse> getEditorialById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(editorialService.getEditorialById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EditorialResponse> createEditorial(@Valid @RequestBody EditorialRequest request) {
        return ResponseEntity.ok(editorialService.createEditorial(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialResponse> updateEditorial(@PathVariable Long id, @Valid @RequestBody EditorialRequest request) {
        return ResponseEntity.ok(editorialService.updateEditorial(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEditorial(@PathVariable Long id) {
        editorialService.deleteEditorial(id);
        return ResponseEntity.noContent().build();
    }
}

