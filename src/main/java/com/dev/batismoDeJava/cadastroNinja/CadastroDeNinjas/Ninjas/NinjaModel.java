package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;
    //Faz com que os itens dessa coluna sejam unicos nela,não possibilitando as repetições do mesmo item
    @Column(unique = true)
    private String email;

    private int idade;

    //uma missão por ninja
    @ManyToOne
    private MissoesModel missoes;



}
