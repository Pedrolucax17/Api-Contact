package br.com.fiap.contact.service;

import br.com.fiap.contact.dto.UserExhibitionDto;
import br.com.fiap.contact.dto.UserRegisterDto;
import br.com.fiap.contact.exception.UserCannotFindException;
import br.com.fiap.contact.model.UserModel;
import br.com.fiap.contact.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserExhibitionDto save(UserRegisterDto userRegisterDto){

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterDto.password());

        UserModel user = new UserModel();
        BeanUtils.copyProperties(userRegisterDto, user);
        user.setPassword(encryptedPassword);

        UserModel userSave = repository.save(user);
        return new UserExhibitionDto(userSave);
    }

    public UserExhibitionDto searchById(Long id){
        Optional<UserModel> userModelOptional = repository.findById(id);
        if (userModelOptional.isPresent()){
            return new UserExhibitionDto(userModelOptional.get());
        }else{
            throw new UserCannotFindException("Usuário não encontrado");
        }
    }

    public Page<UserExhibitionDto> listAllUser(Pageable pegeable){
        return repository.findAll(pegeable).map(UserExhibitionDto::new);
    }

    public UserModel update(UserModel userModel){
        Optional<UserModel> userModelOptional = repository.findById(userModel.getUserId());

        if (userModelOptional.isPresent()){
            return repository.save(userModel);
        }else{
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public void deleteUserById(Long id){
        Optional<UserModel> userModelOptional = repository.findById(id);
        if (userModelOptional.isPresent()){
            repository.delete(userModelOptional.get());
        }else{
            throw new RuntimeException("Usuario não encontrado");
        }
    }
}
