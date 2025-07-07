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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Endpoint - mostrar ninjas por id
    //@PathVariable torna a variavel Long id parte da url,é um 'caminho variavel' pq o usuario vai digitar o valor desse trecho do url
    @GetMapping("/todos/{id}")
    public NinjaDTO listarNinjasPorID(@PathVariable Long id) {
       return ninjaService.NinjaPorID(id);
    }

    //Endpoint - Mostrar os ninjas
    //Metodo depende da injeção de dependencia do service
    @GetMapping("/todos")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Endpoint - alterar dados do ninja por id
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
            return ninjaService.atualizarNinja(id,ninjaAtualizado);
        }


    //Endpoint - Deletar ninjas por id
    @DeleteMapping("/deletar/{id}")
    public void deletarPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }


}

