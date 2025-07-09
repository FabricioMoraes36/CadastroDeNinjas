package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;

    private String nome;

    private RankMissoes rank;

    private List<NinjaModel> ninjas;

}
