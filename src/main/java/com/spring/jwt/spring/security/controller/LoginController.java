package com.spring.jwt.spring.security.controller;

import com.spring.jwt.spring.security.dtos.Login;
import com.spring.jwt.spring.security.dtos.Sessao;
import com.spring.jwt.spring.security.model.User;
import com.spring.jwt.spring.security.repository.UserRepository;
import com.spring.jwt.spring.security.security.JWTCreator;
import com.spring.jwt.spring.security.security.JWTObject;
import com.spring.jwt.spring.security.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login){
        User user = repository.findByUsername(login.userName());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.password(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.userName());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            var token = JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject);
            Sessao sessao = new Sessao(user.getUserName(), token);
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}