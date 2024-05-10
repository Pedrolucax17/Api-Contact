package br.com.fiap.contact.dto;

import java.time.LocalDate;

public record ContactRegisterDto(
        Long id,
        String name,
        String email,
        String password,
        LocalDate birthDate
) {
}
