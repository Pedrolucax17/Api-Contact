package br.com.fiap.contact.repository;

import br.com.fiap.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//JPARepository vai ter tudo que eu preciso para o crud;
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public Optional<Contact> findByName(String name);

    public List<Contact> findByBirthDateBetween(LocalDate initialDate, LocalDate finalDate);
}
