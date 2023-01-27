package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DadosdetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco) {

    public DadosdetalhamentoPaciente(Paciente paciente){

        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getEmail(), paciente.getEndereco());


    }



}
