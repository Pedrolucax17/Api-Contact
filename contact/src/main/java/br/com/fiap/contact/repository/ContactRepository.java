package br.com.fiap.contact.repository;

import br.com.fiap.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//JPARepository vai ter tudo que eu preciso para o crud;
public interface ContactRepository extends JpaRepository<Contact, Long> {
   @Query("SELECT c FROM Contact c WHERE c.name = :name")
    Optional<Contact> searchByName(@Param("name") String name);

   Optional<Contact> findByEmail(String email);

   @Query("SELECT c FROM Contact c WHERE c.birthDate BETWEEN :initialDate AND :finalDate")
   List<Contact> listBirthdayPersonForPeriod(
           @Param("initialDate") LocalDate initialDate,
           @Param("finalDate") LocalDate finalDate
   );
}
