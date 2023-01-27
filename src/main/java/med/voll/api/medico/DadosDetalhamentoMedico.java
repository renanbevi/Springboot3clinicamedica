package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade,
        Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){ // Construtor que recebe um objeto médico
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),medico.getEspecialidade(),medico.getEndereco());

    }

}
