package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NinjaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name ="id")
    private Long id;

    @Column(name ="nome")
    private String nome;

    //Faz com que os itens dessa coluna sejam unicos nela,não possibilitando as repetições do mesmo item
    @Column(unique = true)
    private String email;

    @Column(name ="img_url")
    private String imgUrl;

    @Column(name ="idade")
    private int idade;

    //uma missão por ninja
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;



}
