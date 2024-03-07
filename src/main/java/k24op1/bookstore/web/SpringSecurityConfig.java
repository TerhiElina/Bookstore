package k24op1.bookstore.web;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.security.core.userdetails.User;//import org.hibernate.mapping.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.List;
import java.util.ArrayList;

//Lisätäään annotaatiot
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)

//Luodaan metodi, joka turvaa kaikki URLIT
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
       http
       .authorizeHttpRequests(authorize -> authorize
       .requestMatchers(antMatcher("/css/**")).permitAll() //Mahdollistetaan css, kun ollaan uloskirjautuneita
       .anyRequest().authenticated()
       )
       //Määritellään miten kirjautumissivu konfiguroidaan
       .formLogin(formlogin -> formlogin
       .loginPage("/login")
       .defaultSuccessUrl("/booklist", true) // Asetetaan mille endpointille ohjataan, jos kirjautuminen onnistuu
       .permitAll() // kaikilla on pääsy kirjautumissivulle
       )
       // Määritellään miten uloskirjautuminen konfiguroidaan
       .logout(logout -> logout
       .permitAll()); // kaikilla on oikeus uloskirjautumiseen
       return http.build(); //Palautetaan SecurityFilterChain olio, joka käsittelee pyyntöjä määrittelyjen mukaan
    }
    //Luodaan kaksi testikäyttäjää.
    //HOX! Ei käytetä tuotannossa
    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> users = new ArrayList<UserDetails>();
        //Otetaan passwordendoder käyttöön
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //Luodaan testikäyttäjät
        UserDetails user1 = User
        .withUsername("user")
        .password(passwordEncoder.encode("user")) //Kryptataan salasana
        .roles("USER") //annetaan rooli USER
        .build();
        users.add(user1);

        UserDetails user2 = User
        .withUsername("admin")
        .password(passwordEncoder.encode("admin"))
        .roles("ADMIN")
        .build();
        users.add(user2);

        return new InMemoryUserDetailsManager(users);
    }
    
}
