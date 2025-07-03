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

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();

    }

    public NinjaModel NinjaPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja) ;
    }
}
