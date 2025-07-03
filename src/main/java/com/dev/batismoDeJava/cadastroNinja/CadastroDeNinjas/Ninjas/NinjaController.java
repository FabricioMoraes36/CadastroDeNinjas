package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninjas")
public class NinjaController {
    //Injeção de dependencia do service(NinjaService)
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/BoasVindas")
    public void mensagemController() {
        System.out.println("Bem vindo ao controller Ninjas");
    }

    //Endpoint - Criar ninjas
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }

    //Endpoint - mostrar ninjas por id
    //@PathVariable torna a variavel Long id parte da url,é um 'caminho variavel' pq o usuario vai digitar o valor desse trecho do url
    @GetMapping("/todos/{id}")
    public NinjaModel listarNinjasPorID(@PathVariable Long id) {
       return ninjaService.NinjaPorID(id);
    }

    //Endpoint - Mostrar os ninjas
    //Metodo depende da injeção de dependencia do service
    @GetMapping("/todos")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Endpoint - alterar dados do ninja por id
    @PutMapping("/alterarPorId")
    public String alterarNinjaPorId() {
        return "Dados do ninja atualizados por id";
    }

    //Endpoint - Deletar ninjas por id
    @DeleteMapping("/deletarPorId")
    public String deletarNinja() {
        return "Ninja deletado por id";
    }


}

