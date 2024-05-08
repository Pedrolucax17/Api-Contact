package br.com.fiap.contact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ap")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/ola")
    public String ola(){
        return "<h1>Olá, Mundo!</h1>";
    }
}
