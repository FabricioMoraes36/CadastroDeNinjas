package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    //podemos usar o autowired mas é uma boa pratica criar o construtor
    @Autowired
    //modificador de acesso - classe de repository - nome da variavel(é um padrão ter o mesmo nome do repository)
    //Injeção de dependencia do NinjaRepository pra usar os metodos ja prontos do jpa
    private NinjaRepository ninjaRepository;

    //listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();

    }

    //listar por id
    public NinjaModel NinjaPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //deletar um novo ninja por id - tem que ser void
    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }
    //atualizar ninja

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            return ninjaRepository.save(ninjaAtualizado);

        }
        return null;
    }
}
