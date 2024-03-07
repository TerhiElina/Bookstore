package k24op1.bookstore.web;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.security.core.userdetails.User;//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import k24op1.bookstore.domain.UserDetailServiceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private UserDetailsService userDetailsService;
    //private UserDetailServiceImpl userDetailsService;
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
    //Määritellään miten Spring security käyttää käyttäjätietoja ja
    //määritellään salasanankryptaus
    //configureGlobal on osa Spring securityn konfiguraatiota, jonka avulla määritellään
    //miten userDetailService-palvelua käytetään
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());   
    }
    
}
