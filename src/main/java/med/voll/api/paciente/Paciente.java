package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;


@Table(name="pacientes")
@Entity(name="paciente")


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private  Endereco endereco;

    private boolean ativo;


    public Paciente(DadosCadastroPaciente dados){

        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.cpf = dados.cpf();


    }


}
