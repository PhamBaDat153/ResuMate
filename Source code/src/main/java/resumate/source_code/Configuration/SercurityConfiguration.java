package resumate.source_code.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SercurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allows access to all URLs
                )
                .csrf(csrf -> csrf.disable()) // Often required for stateless REST APIs
                .formLogin(form -> form.disable()) // Removes the default login UI
                .httpBasic(basic -> basic.disable()); // Disables basic pop-up auth

        return http.build();
    }
}
