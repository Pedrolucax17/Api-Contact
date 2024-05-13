package br.com.fiap.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContactRegisterDto(
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email na formatação errada")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, max = 20, message = "A senha deve conter no mínimo 6 e máximo 20 caracteres")
        String password,

        @NotNull(message = "O email é obrigatório")
        LocalDate birthDate
) {
}
