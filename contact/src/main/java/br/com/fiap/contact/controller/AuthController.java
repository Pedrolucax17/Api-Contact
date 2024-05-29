package br.com.fiap.contact.controller;

import br.com.fiap.contact.dto.LoginDto;
import br.com.fiap.contact.dto.UserExhibitionDto;
import br.com.fiap.contact.dto.UserRegisterDto;
import br.com.fiap.contact.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto){
        //Representa o usuario

        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(),
                        loginDto.password()
                );
        Authentication authentication = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserExhibitionDto register(
            @RequestBody @Valid UserRegisterDto userRegisterDto
    ){
        UserExhibitionDto userRegister = null;
        userRegister = service.save(userRegisterDto);

        return userRegister;
    }

}
