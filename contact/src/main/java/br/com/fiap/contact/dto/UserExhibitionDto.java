package br.com.fiap.contact.dto;


import br.com.fiap.contact.model.User;
import br.com.fiap.contact.model.UserRole;

public record UserExhibitionDto(
        Long id,
        String name,
        String email,
        UserRole role
) {
    public UserExhibitionDto(User user) {
        this(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
