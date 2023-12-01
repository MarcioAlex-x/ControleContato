package br.com.controlecontato.config;

import br.com.controlecontato.authentication.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private TokenFilter filter;

    public SecurityConfig() {
        super();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager() ;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/alunos/**").hasRole("USER")
                .requestMatchers("/matricula-aluno/**").hasRole("ADMIN")
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/v2/api-docs", "/swagger-resources/**", "/webjars/**", "/swagger-ui/**").permitAll()
                .anyRequest().authenticated()
                .and().logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")))
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);;
        return http.build();
    }


}