package com.login.flow.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.dto.RedefinirSenhaDTO;
import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

@RestController
public class RedefinirSenhaController { 
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/senha") 
    public Object redefinir(@RequestBody RedefinirSenhaDTO redefinirSenhaDTO) {
        String email = redefinirSenhaDTO.getEmail();
        String senhaAtual = redefinirSenhaDTO.getSenhaAtual();
        String novaSenha = redefinirSenhaDTO.getNovaSenha(); 
        

        Optional<Usuario> redefinirBD = usuarioRepository.findByEmail(email); 

        if(redefinirBD.isEmpty()) {
            return "Usuario nao cadastrado"; 
        }

        Usuario redefinirObj = redefinirBD.get(); 
        String senhaRedefinirBD = redefinirObj.getSenha();

        if(!senhaAtual.equals(senhaRedefinirBD)) {
            return "Senha ou email invalidos"; 
        }
        redefinirObj.setSenha(novaSenha);

        return usuarioRepository.save(redefinirObj);

    
    }
}    
