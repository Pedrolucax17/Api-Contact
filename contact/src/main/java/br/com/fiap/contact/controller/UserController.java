package br.com.fiap.contact.controller;

import br.com.fiap.contact.dto.UserExhibitionDto;
import br.com.fiap.contact.dto.UserRegisterDto;
import br.com.fiap.contact.model.UserModel;
import br.com.fiap.contact.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserExhibitionDto save(@RequestBody @Valid UserRegisterDto user){
        return userService.save(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserExhibitionDto> listAll(Pageable pageable){
        return userService.listAllUser(pageable);
    }

    @GetMapping("/users/id/{userId}")
    public ResponseEntity<UserExhibitionDto> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.searchById(userId));
    }

    @DeleteMapping("/users/id/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public UserModel update(@RequestBody UserModel user){
        return userService.update(user);
    }

}
