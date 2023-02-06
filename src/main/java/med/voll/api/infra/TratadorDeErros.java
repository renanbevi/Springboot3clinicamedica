package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //dizer ao spring classe que trata erros
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)//Quando esse metodo vai ser chamado pra essa  exception
    public ResponseEntity tratarErro404(){

        return ResponseEntity.notFound().build();  // Build cria a exception.
    }

}
