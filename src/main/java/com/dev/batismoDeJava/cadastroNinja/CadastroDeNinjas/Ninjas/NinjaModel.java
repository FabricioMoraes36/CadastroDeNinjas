package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;
import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private List<MissoesModel> missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
