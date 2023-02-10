package med.voll.api.infra.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  //indicar ao spring que vamos personalizar as configurações de segurança
public class SecurityConfigurations {

    @Bean  // Serve para expor o retorno do método para o Spring.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  //usado para configurar sobre processos de autorização
        // csrf desabilita a proteção contra ataques
        return http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().build(); //Spring quero desabilitar o processo de autentificação e que seja Stateless pois é uma API REST
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception { // metodo para criar o authenticationManager
            return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
