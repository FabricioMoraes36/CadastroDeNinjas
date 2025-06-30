package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/BoasVindas")
    public void mensagemController(){
        System.out.println("Bem vindo ao controller Ninjas");
    }

    //Endpoint - Criar ninjas
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado com sucesso!!";
    }

    //Endpoint - mostrar ninjas por id
    @GetMapping("/todosId")
    public String buscaNinjaPorId(){
        return "Mostrar ninja por Id";
    }

    //Endpoint - Mostrar os ninjas
    @GetMapping("/todos")
    public String buscaNinja(){
        return "Mostrar todos os ninjas";
    }

    //Endpoint - alterar dados do ninja por id
    @PutMapping("/alterarPorId")
    public String alterarNinjaPorId(){
        return "Dados do ninja atualizados por id";
    }

    //Endpoint - Deletar ninjas por id
    @DeleteMapping("/deletarPorId")
    public String deletarNinja(){
        return "Ninja deletado por id";
    }





}
