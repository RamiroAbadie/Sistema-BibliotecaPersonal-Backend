package com.MiBiblioteca.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Sexo {
    M, F;

    @JsonCreator
    public static Sexo fromString(String value) {
        if (value == null) return null;
        try {
            return Sexo.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El sexo debe ser 'M' o 'F'");
        }
    }
}

