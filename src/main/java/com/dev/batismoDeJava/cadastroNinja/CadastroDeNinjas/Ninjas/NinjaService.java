package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    //podemos usar o autowired mas é uma boa pratica criar o construtor
    //@Autowired
    //modificador de acesso - classe de repository - nome da variavel(é um padrão ter o mesmo nome do repository)
    //Injeção de dependencia do NinjaRepository pra usar os metodos ja prontos do jpa
    private final NinjaRepository ninjaRepository;
    //instancia do mapper
    private final NinjaMapper ninjaMapper;

    //recriamos o construtor com o ninjaMapper ja incluso
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar todos os ninjas
    public List<NinjaDTO> listarNinjas() {
        //cria uma list chamada ninjas que recebe o tipo NinjaModel
        //e essa lista ira receber todos os ninjas cadastrados no db pelo ninjaRepository.findAll();
        //todos os cadastrados no db são do tipo ninjaModel ja que o db não aceita DTO no caso
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        //Inicia uma stream com essa lista de NinjaModel, a ninjas inicia a stream
        //na frente do () aparece Stream<NinjaModel> mas isso é algo implicito,o intelliJ mostra pra facilitar o entendimento
        return ninjas.stream()
                //como List recebe nela os NinjaModel para cada NinjaModel dentro dela, aplica a função ninjaMapper.map()
                //Isso transforma NinjaModel em NinjaDTO
                // aqui o Stream<NinjaDTO> pode estar implicito tambem mas n faz parte do codigo diretamente
                //aqui o :: tem a mesma função que o lambda sabe ->
                .map(ninjaMapper::map)

                //Coleta(junta) todos os NinjaDTOs transformados anteriormente,coleta com o collect
                //coloca numa nova lista do tipo List<NinjaDTO> pelo Collectors.toList
                //basicamente é assim: ó pega tudo ai que foi transformado,agora o collectors(recebe tudo coletado pelo collect)
                //o collectors vai usar o metodo toList pra criar uma lista,e como tudo foi transformado em DTO ele faz uma list de DTO
                .collect(Collectors.toList());
    }

    //listar por id
    //passamos o Long id pois sera a variavel da nossa url
    public NinjaDTO NinjaPorID(Long id) {
        //Criamos um optional do tipo NinjaModel que tem o nome ninjaporId, e esse optional chama o ninjaRepository com o metodo findById
        //é do tipo NinjaModel pq o ninja que ele receber,o ninja do id que passarmos,ele vem como model,e nos iremos retornar ele como um dto,serviço que o mapper faz
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        //retornamos o nosso optional chamando o metodo map
        //dentro do map passamos o nosso ninjaMapper com o metodo map,isso é o mesmo que dizer,agora o mapper vai mapear o model como dto
        //colocamos o orElse(null) pq vai que o usuario passa um id que n existe
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    //aqui n precisamos do dto,pq de informação do model so pegamos o id
    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }
    // Atualizar ninja
// Esse metodo tende a ser um pouco mais complexo porque estamos atualizando todos os dados do ninja,
// não só um campo. É como se estivéssemos sobrescrevendo o ninja com novos dados para aquele ID.
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {

        // Aqui criamos um Optional chamado ninjaExiste que tenta encontrar um ninja com o ID passado.
        // Usamos findById, que pode ou não encontrar esse ninja no banco.
        Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id);

        // Se o ninja foi encontrado no banco (ou seja, o Optional está preenchido), seguimos com a atualização.
        if (ninjaExiste.isPresent()) {

            // Convertendo os dados do DTO recebido (com os novos valores) para um Model.
            // Isso porque o banco só aceita Model, não DTO.
            // O mapper faz essa conversão pra gente.
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);

            // Garantimos que o ID do ninja vai continuar o mesmo, pra não criar um novo no banco.
            ninjaAtualizado.setId(id);

            // Salvamos esse Model no banco. O metodo save atualiza se o ID já existe.
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);

            // Por fim, transformamos o Model salvo de volta para DTO,
            // que é o formato que usamos para devolver a resposta pro usuário (geralmente em JSON).
            return ninjaMapper.map(ninjaSalvo);
        }

        //la no if,se não encontrar o ninja com o ID passado, não faz nada e retorna null.
        return null;
    }
 }





