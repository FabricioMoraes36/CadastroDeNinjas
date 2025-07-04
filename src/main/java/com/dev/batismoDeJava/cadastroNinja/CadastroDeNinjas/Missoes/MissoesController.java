package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/boasVindas")
    public void mensagemController(){
        System.out.println("Bem vindo ao controller Missões");;
    }
    //Endpoint - criar missão
    //POST - REQUISIÇÃO PARA CRIAR MISSÃO
    //Precisa de um json correto para criar no db
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //Endpoint - procurar missão por id
    //GET - REQUISIÇÃO PARA MOSTRAR MISSÃO POR ID
    //@PathVariable indica que Long id fará parte da url
    @GetMapping("/todos/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //Endpoint - mostrar todas as missões
    //GET - REQUISIÇÃO PARA MOSTRAR TODAS MISSÕES
    @GetMapping("/todos")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //Endpoint - deletar a missão por id
    //DELETE - REQUISIÇÃO PARA DELETAR MISSÃO POR ID
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

    //Endpoint - atualizar a missão por id
    //PUT - REQUISIÇÃO PARA ATUALIZAR A MISSÃO POR ID
    @PutMapping("/alterarPorId")
    public String atualizarMissaoPorId(){
        return "Missão atualizada por id";
    }

}
