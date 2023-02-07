package med.voll.api.domain.usuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="usuarios")
@Entity(name="Usuario") // mesmo nome da classe


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
//entidade JPA
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

}
