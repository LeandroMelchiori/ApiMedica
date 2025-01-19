package med.vol.api.infra.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // le indicamos a Spring el tipo de sesion
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(HttpMethod.POST,"/login")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // llamada a nuestro filtro antes que el de spring
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//En la aplicación utilizada en el curso,
//no tendremos diferentes perfiles de acceso para los usuarios.
//        Sin embargo, esta característica se usa en algunas aplicaciones
//y podemos indicarle a Spring Security que solo los usuarios que tienen un perfil específico pueden acceder a ciertas URL.
//        Por ejemplo, supongamos que en nuestra aplicación tenemos un perfil de acceso llamado ADMIN,
//y solo los usuarios con ese perfil pueden eliminar médicos y pacientes.
//Podemos indicar dicha configuración a Spring Security cambiando el método securityFilterChain,
//en la clase SecurityConfigurations, de la siguiente manera:
//
//@Bean

//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http.csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and().authorizeRequests()
//            .antMatchers(HttpMethod.POST, "/login").permitAll()
//            .antMatchers(HttpMethod.DELETE, "/medicos").hasRole("ADMIN")
//            .antMatchers(HttpMethod.DELETE, "/pacientes").hasRole("ADMIN")
//            .anyRequest().authenticated()
//            .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//            .build();
//}