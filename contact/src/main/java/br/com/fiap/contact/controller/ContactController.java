package br.com.fiap.contact.controller;

import br.com.fiap.contact.model.Contact;
import br.com.fiap.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Contact record(@RequestBody Contact contact){
        return service.record(contact);
    }
    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> listAllContacts(){
        return service.listAllContacts();
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

    @GetMapping("/contacts/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Contact searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping("/contacts/{initialDate}/{finalDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> showBirthdays(
            @PathVariable LocalDate initialDate, @PathVariable LocalDate finalDate
    ){
        return service.showBirthdays(initialDate, finalDate);
    }
}