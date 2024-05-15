package br.com.fiap.contact.controller;

import br.com.fiap.contact.dto.ContactExhibitionDto;
import br.com.fiap.contact.dto.ContactRegisterDto;
import br.com.fiap.contact.model.Contact;
import br.com.fiap.contact.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired //Vai inicilizar o atributo
    private ContactService service;

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactExhibitionDto record(@RequestBody @Valid ContactRegisterDto contact){
        return service.recordData(contact);
    }

    @GetMapping("/contacts/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactExhibitionDto searchById(@PathVariable Long id){
        return service.searchById(id);
    }

    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public Page<ContactExhibitionDto> listAllContacts(Pageable page){
        return service.listAllContacts(page);
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id){
        service.deleteContactsById(id);
    }

    @PutMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public Contact updateContact(@RequestBody Contact contact){
        return service.update(contact);
    }


    @GetMapping("/contacts/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ContactExhibitionDto searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping(value = "/contacts", params = {"initialDate", "finalDate"})
    public List<ContactExhibitionDto> listBirthdayPersonForPeriod(
            @RequestParam LocalDate initialDate,
            @RequestParam LocalDate finalDate
    ){
        return service.listBirthdayPersonForPeriod(initialDate, finalDate);
    }

    @GetMapping(value = "/contacts", params = "email")
    public ContactExhibitionDto findContactByEmail(@RequestParam String email){
        return service.findContactByEmail(email);
    }
}
