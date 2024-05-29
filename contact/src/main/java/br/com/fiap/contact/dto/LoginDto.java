package br.com.fiap.contact.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "O email está no formato errado")
        String email,
        @NotBlank(message = "Senha é obrigatório")
        @Size(min = 6, max = 20, message = "Senha deve conter entre 6 e 20 caracteres")
        String password
) {
}
