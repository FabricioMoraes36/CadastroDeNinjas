package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso!" + novoNinja.getNome() + " E tem o id: " + novoNinja.getId());
    }
    //Endpoint - mostrar ninjas por id
    //@PathVariable torna a variavel Long id parte da url,é um 'caminho variavel' pq o usuario vai digitar o valor desse trecho do url
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.NinjaPorID(id);
        if (ninja!= null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe ninja cadastrado nesse id:" + id);

    }

    //Endpoint - Mostrar os ninjas
    //Metodo depende da injeção de dependencia do service
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO>ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Endpoint - alterar dados do ninja por id
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.NinjaPorID(id);
       if (ninja != null){
           ninjaService.atualizarNinja(id,ninjaAtualizado);
           return ResponseEntity.ok(ninja);
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe ninja cadastrado nesse id:" + id);
       }
        }


    //Endpoint - Deletar ninjas por id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId (@PathVariable Long id) {
       if(ninjaService.NinjaPorID(id)!= null){
           ninjaService.deletarPorId(id);
           return ResponseEntity.ok("Ninja do id: " + id + " Deletado com sucesso");
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe ninja cadastrado nesse id:" + id);
       }

    }


}

