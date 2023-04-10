package com.example.demo.grobal.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
//    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    // private final CheckIsSameTempFilter checkIsSameTempFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        csrf(http);
        http
        //    .addFilterAfter(checkIsSameTempFilter, OAuth2LoginAuthenticationFilter.class)
            .headers(header -> header
                    .frameOptions()
                    .sameOrigin()
            )
            .authorizeHttpRequests(httpRequests -> httpRequests
                    .requestMatchers("/all").hasAuthority("ROLE_USER")
                    .requestMatchers("/h2").permitAll()
                    .anyRequest().authenticated()
            )
            .oauth2Login().and()
//            .oauth2Login(oauth2 -> oauth2
//                    .authorizedClientService(oAuth2AuthorizedClientService)
//                    .successHandler(authenticationSuccessHandler)
//            )
            .formLogin().disable()
            .logout();
        return http.build();
    }

    private HttpSecurity csrf(HttpSecurity http) throws Exception {
        return http.csrf().disable();
    }

}
