package med.voll.api.medico;


import med.voll.api.endereco.DadosEndereco;

//Bin validation validar os campos do Json o que são obrigatórios
public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco) {
}
