package com.domain.devmovie.configurations;

import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/*").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/users/*").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/users/search").authenticated()

                        .requestMatchers(HttpMethod.POST, "/api/movie-lists").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/movie-lists/*").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/movie-lists/*").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/movie-lists/*/add-movie").authenticated()

                        .requestMatchers(HttpMethod.GET, "/api/user-movies/*/favorites").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/user-movies/*/favorites").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/user-movies/favorites/*").authenticated()

                        .requestMatchers(HttpMethod.POST, "/api/ratings").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/ratings/user/*").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/ratings/movie/*").permitAll()

                        .anyRequest().authenticated()
                )
                //.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.frameOptions(
                                HeadersConfigurer.FrameOptionsConfig::disable
                        )
                ).build();
    }
}
