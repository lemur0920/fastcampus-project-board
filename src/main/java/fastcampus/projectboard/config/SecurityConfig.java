package fastcampus.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/login")    // Custom 로그인페이지 필요
                                .defaultSuccessUrl("/articles")
                );
            http
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());
            return http.build();
    }
}
