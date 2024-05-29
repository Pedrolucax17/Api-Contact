package br.com.fiap.contact.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${my.secret.key}")
    private String secretWord;
}
