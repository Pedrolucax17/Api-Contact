package br.com.fiap.contact.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "tbl_contacts")
public class Contact {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CONTACT_SEQ"
    )
    @SequenceGenerator(
            name = "CONTACT_SEQ",
            sequenceName = "CONTACT_SEQ",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(name, contact.name) && Objects.equals(email, contact.email) && Objects.equals(birthDate, contact.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthDate);
    }
}
