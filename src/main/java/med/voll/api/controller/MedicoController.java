package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController //essa classe é um controller Rest carregue a classe
@RequestMapping("medicos")
public class MedicoController {

    @Autowired //injeção de dependencia
    private MedicoRepository repository; //interface repository

    @PostMapping
    @Transactional //método de inscrita para fazer o insert no banco de dados
    //Classe no padrão DTO seu objetivo é apenas representar dados que serão recebidos ou devolvidos pela API, sem nenhum tipo de comportamento.
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ //informar o spring que o parametro json vai puxar do corpo da requisição
        repository.save(new Medico(dados)); // parametro 1 null porque o banco de dados que vai gerar o ID pra gente
    }
    @GetMapping   //somente para leitura
    public Page<DadosListagemMedico> listar(Pageable paginacao){ //listar todos os medicos no banco

         return repository.findAll(paginacao).map(DadosListagemMedico::new); //fazer um mapeamento para converter de Médico para Listagem Medico classe To list para converter para uma lista
    } // Conversão de médico para Dados Listagem médicos.
      // Oageable classe do Spring para paginação na hora de listar todos os itens
      // Page devolve informações sobre paginação com a lista dos dados dos médicos.

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());  //busca a referencia do ID
        medico.atualizarInformacoes(dados); // carreguei os dados do medico e vou atualizar com as informações atual

    }
    @DeleteMapping("/{id}") // avisar que o id que vem no método esta vindo no ID do postman
    @Transactional
    public void excluir(@PathVariable Long id){ //  PathVariable Uma variavel da URL deleteMapping

        repository.deleteById(id); // faz o delete por ID
    }

}
