package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
//Torna essa nossa classe uma entidade para o banco de dados
@Entity
//Cria uma tabela e podemos dar um nome pra ela seguindo o padrão tb_
@Table(name = "tb_missoes")
//cria getters e setters
@Data
//Cria um construtor com todos os argumentos
@ToString
@AllArgsConstructor
//Cria um construtor sem argumento algum
@NoArgsConstructor

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private RankMissoes rank;

    // uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel>ninjas;

}
