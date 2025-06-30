package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/BoasVindas")
    public void mensagemController(){
        System.out.println("Essa é minha primeira mensagem");
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
        return "Mostrar ninjas";
    }

    //Endpoint - alterar dados do ninja por id
    @PutMapping("/alterarPorId")
    public String alterarNinjaPorId(){
        return "Dados alterados com sucesso pelo id";
    }

    //Endpoint - Deletar ninjas por id
    @DeleteMapping("/deletarPorId")
    public String deletarNinja(){
        return "Ninja deletado com sucesso pelo id";
    }





}
