package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //essa classe é um controller Rest carregue a classe
@RequestMapping("medicos")
public class MedicoController {

    @Autowired //injeção de dependencia
    private MedicoRepository repository; //interface repository

    @PostMapping
    @Transactional //método de inscrita para fazer o insert no banco de dados
    //Classe no padrão DTO seu objetivo é apenas representar dados que serão recebidos ou devolvidos pela API, sem nenhum tipo de comportamento.
    public void cadastrar(@RequestBody DadosCadastroMedico dados){ //informar o spring que o parametro json vai puxar do corpo da requisição

        repository.save(new Medico(dados)); // parametro 1 null porque o banco de dados que vai gerar o ID pra gente
    }

}
