package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //essa classe é um controller Rest carregue a classe
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    //Classe no padrão DTO seu objetivo é apenas representar dados que serão recebidos ou devolvidos pela API, sem nenhum tipo de comportamento.
    public void cadastrar(@RequestBody DadosCadastroMedico dados){ //informar o spring que o parametro json vai puxar do corpo da requisição
        System.out.println(dados); //recebendo informações de um post


    }

}
