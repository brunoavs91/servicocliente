package com.boaentrega.servicocliente.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//.antMatchers(HttpMethod.POST, "/algo").hasRole("USER") vc valida algum endpoint especifico
                .anyRequest()
                .authenticated();
    }
}
