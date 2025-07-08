package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    @GetMapping("/BoasVindas")
    @Operation(summary = "Mensagem de boas vindas",description = "exibe uma mensagem de boas vindas para quem acessar essa rota")
    public void mensagemController() {
        System.out.println("Bem vindo ao controller Ninjas");
    }

    //Endpoint - Criar ninjas
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja",description = "cadastra um novo ninja no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao criar o ninja")
    })
    public ResponseEntity<String> criarNinja(@Parameter(description = "Espera os dados de acordo com os da requisição")@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso!" + novoNinja.getNome() + " E tem o id: " + novoNinja.getId());
    }
    //Endpoint - mostrar ninjas por id
    //@PathVariable torna a variavel Long id parte da url,é um 'caminho variavel' pq o usuario vai digitar o valor desse trecho do url
    @GetMapping("/todos/{id}")
    @Operation(summary = "Lista o ninja por id",description = "exibe o ninja de acordo com o id fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja encontrado por id com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao encontrar o ninja no id")
    })
    public ResponseEntity<?> listarNinjasPorID(@Parameter(description = "Espera o id no caminho da rota") @PathVariable Long id) {
        NinjaDTO ninja = ninjaService.NinjaPorID(id);
        if (ninja!= null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe ninja cadastrado nesse id:" + id);

    }

    //Endpoint - Mostrar os ninjas
    //Metodo depende da injeção de dependencia do service
    @GetMapping("/todos")
    @Operation(summary = "Lista todos os ninjas cadastrados",description = "Lista todos os ninjas cadastrados no banco de dados")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO>ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Endpoint - alterar dados do ninja por id
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id",description = "altera os dados do ninja de acordo com o id fornecido")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja alterado por id com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao alterar o ninja no id")
    })
    public ResponseEntity<?> alterarNinja(@Parameter(description = "Espera o id no caminho da rota")@PathVariable Long id,@Parameter(description = "Espera os dados de acordo com os da requisição")@RequestBody NinjaDTO ninjaAtualizado) {
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
    @Operation(summary = "Deleta o ninja por id",description = "Deleta o ninja de acordo com o id fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja deletado por id com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao deletar o ninja no id")
    })
    public ResponseEntity<String> deletarNinjaPorId (@Parameter(description = "Espera o id no caminho da rota")@PathVariable Long id) {
       if(ninjaService.NinjaPorID(id)!= null){
           ninjaService.deletarPorId(id);
           return ResponseEntity.ok("Ninja do id: " + id + " Deletado com sucesso");
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe ninja cadastrado nesse id:" + id);
       }

    }


}

