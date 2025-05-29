package com.domain.devmovie.configurations;

import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/*").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/users/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/search").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/movie-lists").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/movie-lists/*").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/movie-lists/*").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/movie-lists/*/add-movie").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/user-movies/*/favorites").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/user-movies/*/favorites").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/user-movies/favorites/*").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/ratings").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/ratings/user/*").permitAll()
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
