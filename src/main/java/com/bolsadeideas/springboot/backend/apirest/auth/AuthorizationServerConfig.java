package com.bolsadeideas.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer //Se habilita esta configuracion
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //Aqui se configura los permisos de rutas de acceso
        security.tokenKeyAccess("permiteAll()") //damos permiso a cualquier usuario para su autenticacion
        .checkTokenAccess("isAuthenticated()"); //validar token y dar acceso
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //Metodo para autenticar el cliente por lado de la aplicacion y otro por el usuario
        clients.inMemory().withClient("angularapp")
        .secret(passwordEncoder.encode("12345"))
        .scopes("read", "write")
        .authorizedGrantTypes("password", "refresh_token") // token de acceso renovado sin iniciar session
        .accessTokenValiditySeconds(3600)//tiempo de expiracion
        .refreshTokenValiditySeconds(3600); //tiempo de expiracion para refresh
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //Se encarga de t0do el proceso de autenticacion y validar y genera token y entregar al usuario el token
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter()); // Componente encargado de manejar el token,
                                                                // almacena datos de autenticacion
                                                                // (user, role) que serian los claims.
                                                                // Convierte o traduce los datos del token
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        //Trabaja con toda la implementacion del token JWT para traducir la informacion / decodifica y codificar los datos
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        return jwtAccessTokenConverter;
    }
}
