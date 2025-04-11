package projet3.maison.leloire.security;


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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration  // @Configuration : Nous permet d'indiquer les Bean et permet à l'application de les découvrir.
@EnableWebSecurity // @EnableWebSecurity : permet de faire la sécurité au niveau web
public class SpringSecurityConfig {

    // Injecté par son mutateur.
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    //  Beans  //
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .requestMatchers("api/rest/catalog/**").permitAll()
                .requestMatchers("api/rest/rdv/**").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("api/rest/space/**").permitAll()
                .requestMatchers("api/rest/security/**").permitAll() // permitAll : tout le monde peut aller vers les endpoints de security
                .requestMatchers("api/rest/mensuration/**").hasAnyAuthority("ADMIN")
                .requestMatchers("api/rest/test/user/**").hasAnyAuthority("USER", "ADMIN") // Seulement USER ET ADMIN peuvent y accéder
                .requestMatchers("api/rest/test/admin/**").hasAuthority("ADMIN")
                .anyRequest().permitAll();// Seulement les ADMIN peuvent y accéder
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }



    @Bean  // Lorsque l'on va appeler un AuthenticationManager, spring va automatiquement appeler ce Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws  Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //  Mutateur  //
    @Autowired
    public void setJwtAuthenticationFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
}
