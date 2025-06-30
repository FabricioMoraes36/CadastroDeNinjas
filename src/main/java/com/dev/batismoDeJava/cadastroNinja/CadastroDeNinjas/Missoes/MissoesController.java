package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    @GetMapping("/boasVindas")
    public void mensagemController(){
        System.out.println("Bem vindo ao controller Missões");;
    }
    //Endpoint - criar missão
    //POST - REQUISIÇÃO PARA CRIAR MISSÃO
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso!!";
    }

    //Endpoint - procurar missão por id
    //GET - REQUISIÇÃO PARA MOSTRAR MISSÃO POR ID
    @GetMapping("/todosId")
    public String procurarMissaoPorId(){
        return "Mostrar missão por id";
    }

    //Endpoint - mostrar todas as missões
    //GET - REQUISIÇÃO PARA MOSTRAR TODAS MISSÕES
    @GetMapping("/todos")
    public String mostrarTodasAsMissoes(){
        return "Mostrar todas as missões";
    }

    //Endpoint - atualizar a missão por id
    //PUT - REQUISIÇÃO PARA ATUALIZAR A MISSÃO POR ID
    @PutMapping("/alterarPorId")
    public String atualizarMissaoPorId(){
        return "Missão atualizada por id";
    }
    //Endpoint - deletar a missão por id
    //DELETE - REQUISIÇÃO PARA DELETAR MISSÃO POR ID
    @DeleteMapping("/deletarPorId")
    public String deletarMissaoPorId(){
        return "Missão deletada por id";
    }

}
