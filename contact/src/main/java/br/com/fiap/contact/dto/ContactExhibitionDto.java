package br.com.fiap.contact.dto;

import br.com.fiap.contact.model.Contact;

import java.time.LocalDate;

public record ContactExhibitionDto(
        Long id,
        String name,
        String email,
        LocalDate birthday
) {
    public ContactExhibitionDto(Contact contact){
        this(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getBirthDate()
        );
    }
}
