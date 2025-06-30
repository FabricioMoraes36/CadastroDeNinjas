package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {
    public String boasVindas(){
        return "Boas vindas as missoes";
    }
    //Endpoint - criar missão
    //POST - REQUISIÇÃO PARA CRIAR MISSÃO
    @PostMapping("/criarMissao")
    public String criarMissao(){
        return "Missão criada com sucesso!!";
    }

    //Endpoint - procurar missão por id
    //GET - REQUISIÇÃO PARA MOSTRAR MISSÃO POR ID
    @GetMapping("/procurarPorId")
    public String procurarMissaoPorId(){
        return "Missão procurada por Id";
    }

    //Endpoint - mostrar todas as missões
    //GET - REQUISIÇÃO PARA MOSTRAR TODAS MISSÕES
    @GetMapping("/todos")
    public String mostrarTodasAsMissoes(){
        return "Mostrar todas as missões";
    }

    //Endpoint - atualizar a missão por id
    //PUT - REQUISIÇÃO PARA ATUALIZAR A MISSÃO POR ID
    @PutMapping("/atualizarPorId")
    public String atualizarMissaoPorId(){
        return "Missão atualizada por id";
    }
    //Endpoint - deletar a missão por id
    //DELETE - REQUISIÇÃO PARA DELETAR MISSÃO POR ID
    @DeleteMapping("/deletarId")
    public String deletarMissaoPorId(){
        return "Missão deletada por id";
    }

}
