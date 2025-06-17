package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/BoasVindas")
    public void mensagemController(){
        System.out.println("Essa é minha primeira mensagem");
    }
}
