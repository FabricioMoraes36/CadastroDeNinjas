package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @Autowired
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
     MissoesDTO novaMissao = missoesService.criarMissao(missao);
     return ResponseEntity.status(HttpStatus.CREATED).body("Missão criada com sucesso");
    }

    //Endpoint - procurar missão por id
    //GET - REQUISIÇÃO PARA MOSTRAR MISSÃO POR ID
    //@PathVariable indica que Long id fará parte da url
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> missaoPorId (@PathVariable Long id){
       MissoesDTO missao = missoesService.listarMissoesPorId(id);
       if (missao != null){
           return ResponseEntity.ok(missao);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrado no id fornecido" + id);
    }

    //Endpoint - mostrar todas as missões
    //GET - REQUISIÇÃO PARA MOSTRAR TODAS MISSÕES
    @GetMapping("/todos")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //Endpoint - deletar a missão por id
    //DELETE - REQUISIÇÃO PARA DELETAR MISSÃO POR ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Ninja do id: " + id + " Deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrado no id fornecido" + id);
        }
    }

    //Endpoint - atualizar a missão por id
    //PUT - REQUISIÇÃO PARA ATUALIZAR A MISSÃO POR ID
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarMissaoPorId(@PathVariable Long id,@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if (missao != null){
            MissoesDTO missaoAlterada = missoesService.alterarMissaoPorId(id,missoesDTO);
            return ResponseEntity.ok(missaoAlterada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado no id fornecido" + id);
    }

}
