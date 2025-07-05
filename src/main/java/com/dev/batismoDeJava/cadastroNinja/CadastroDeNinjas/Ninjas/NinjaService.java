package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    //podemos usar o autowired mas é uma boa pratica criar o construtor
    //@Autowired
    //modificador de acesso - classe de repository - nome da variavel(é um padrão ter o mesmo nome do repository)
    //Injeção de dependencia do NinjaRepository pra usar os metodos ja prontos do jpa
    private NinjaRepository ninjaRepository;
    //instancia do mapper
    private NinjaMapper ninjaMapper;
    //recriamos o construtor com o ninjaMapper ja incluso
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

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
     //- cria um metodo do tipo NinjaDTO,e o paramentro é um NinjaDTO chamado ninjaDTO
     //- instanciamos o tipo ninjaModel chamado ninja1 que recebe um novo NinjaMapper,usa o metodo map e passamos o ninjaDTO do parametro,mapeamos o model como DTO
     //- atribuimos ao ninja o valor de = ninjaRepository.save(ninja); ele esta salvando a instancia do nosso ninjaModel que chamamos de ninja
     //- depois so retornamos a instancia do nosso mapper(ninjaMapper que ate fizemos o construtor junto com o ninjaRepository la em cima)
     //- e o ninjaMapper usa o metodo pra mapear o ninja,que é a instancia do nosso model

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        //- basicamente,transformamos o model em dto
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        //- salvamos usando o ninjaRepository
        ninja = ninjaRepository.save(ninja);
        //- aqui convertemos de volta,agora de DTO para model
        return ninjaMapper.map(ninja);
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
