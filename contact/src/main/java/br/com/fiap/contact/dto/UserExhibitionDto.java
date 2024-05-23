package br.com.fiap.contact.dto;


import br.com.fiap.contact.model.UserModel;

public record UserExhibitionDto(
        Long id,
        String name,
        String email
) {
    public UserExhibitionDto(UserModel user) {
        this(
                user.getUserId(),
                user.getName(),
                user.getEmail()
        );
    }
}
