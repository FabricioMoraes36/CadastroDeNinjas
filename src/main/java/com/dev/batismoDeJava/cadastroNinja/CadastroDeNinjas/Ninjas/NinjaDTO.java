package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;

import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    //atributos sem annotations referentes ao banco de dados

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private int idade;

    private MissoesModel missoes;

    //A migration que haviamos feito pra coluna rank agora pode ser declarado no dto como um atributo igual aos outros
    private String rank;



}
