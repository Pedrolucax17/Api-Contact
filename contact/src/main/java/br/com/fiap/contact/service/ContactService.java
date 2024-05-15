package br.com.fiap.contact.service;

import br.com.fiap.contact.dto.ContactExhibitionDto;
import br.com.fiap.contact.dto.ContactRegisterDto;
import br.com.fiap.contact.exception.UserCannotFindException;
import br.com.fiap.contact.model.Contact;
import br.com.fiap.contact.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public ContactExhibitionDto recordData(ContactRegisterDto contactRegisterDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRegisterDto, contact);
        return new ContactExhibitionDto(contactRepository.save(contact));
    }

    public ContactExhibitionDto searchById(Long id){
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if(contactOptional.isPresent()){
            return new ContactExhibitionDto(contactOptional.get());
        }else{
            throw new UserCannotFindException("Contato não encontrado");
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



    public Contact update(Contact contact){
        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());

        if(contactOptional.isPresent()){
            return contactRepository.save(contact);
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public ContactExhibitionDto searchByName(String name){
        Optional<Contact> contactOptional = contactRepository.searchByName(name);
        if (contactOptional.isPresent()){
            return new ContactExhibitionDto(contactOptional.get());
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public List<ContactExhibitionDto> listBirthdayPersonForPeriod(LocalDate initialDate, LocalDate finalDate){
        return contactRepository
                .listBirthdayPersonForPeriod(initialDate, finalDate)
                .stream()
                .map(ContactExhibitionDto::new)
                .toList();
    }

    public ContactExhibitionDto findContactByEmail(String email){
        Optional<Contact> contactOptional = contactRepository.findByEmail(email);
        if(contactOptional.isPresent()){
            return new ContactExhibitionDto(contactOptional.get());
        }else{
            throw new UserCannotFindException("Contato não encontrado");
        }
    }
}
