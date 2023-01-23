package med.voll.api.medico;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.*;

//Bin validation validar os campos do Json o que são obrigatórios

public record DadosCadastroMedico(
        @NotBlank // verifica o atributo não pode ser nulo nem vazio
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //passamos uma expressão regular 4,6 de 4 a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid // validando o dados cadastro médico dentro dele é outro DTO e precisa validar também.
        DadosEndereco endereco) {


}
