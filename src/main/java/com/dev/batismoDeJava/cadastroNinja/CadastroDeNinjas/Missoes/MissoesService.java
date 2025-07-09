package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Missoes;

import com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as missões
    public List<MissoesDTO>listarMissoes(){
        List<MissoesModel>lista = missoesRepository.findAll();
        return lista.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());

    }

    //Listar por id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel>listarPorId = missoesRepository.findById(id);
        return listarPorId.map(missoesMapper::map).orElse(null);
    }

    //Criar missão

    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoesDTO ){
        MissoesModel missao = new MissoesMapper().map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //Deletar missão por id *Delete não colocamos o DTO pq nenhum dado sensivel será exposto para os usuarios*
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    //Alterar missão por id

    public MissoesDTO alterarMissaoPorId(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        if (missao.isPresent()){
            MissoesModel missaoAtt = missoesMapper.map(missoesDTO);
            missaoAtt.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtt);
            return missoesMapper.map(missaoSalva);

        }
        return null;
    }
}
