package com.bolsadeideas.springboot.backend.apirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer //Habilitar el servidor de recurso
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    //Metodo que permite implementar todas las reglas de seguridad de nuestros endpoints
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**")
                .permitAll()//Todas las rutas publicas
                .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
                .antMatchers("/api/clientes/**").hasRole("ADMIN")

        .anyRequest().authenticated(); //Cualquier otro request debe ser autenticado
    }
}
