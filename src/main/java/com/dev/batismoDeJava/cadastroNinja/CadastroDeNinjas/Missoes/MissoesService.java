package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missões
    public List<MissoesModel>listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel>listarPorId = missoesRepository.findById(id);
        return listarPorId.orElse(null);
    }

    //Criar missão

    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Deletar missão por id
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
