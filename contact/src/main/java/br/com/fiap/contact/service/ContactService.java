package br.com.fiap.contact.service;

import br.com.fiap.contact.model.Contact;
import br.com.fiap.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact record(Contact contact){
        return contactRepository.save(contact);
    }

    public Contact searchById(Long id){
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if(contactOptional.isPresent()){
            return contactOptional.get();
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public List<Contact> listAllContacts(){
        return contactRepository.findAll();
    }

    public void deleteContactsById(Long id){
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if(contactOptional.isPresent()){
            contactRepository.delete(contactOptional.get());
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public List<Contact> showBirthdays(LocalDate initialDate, LocalDate finalDate){
        return contactRepository.findByBirthDateBetween(initialDate, finalDate);
    }

    public Contact update(Contact contact){
        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());

        if(contactOptional.isPresent()){
            return contactRepository.save(contact);
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public Contact searchByName(String name){
        Optional<Contact> contactOptional = contactRepository.findByName(name);
        if (contactOptional.isPresent()){
            return contactOptional.get();
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }
}
