package com.igloosyrup.paimonquests.configuration;

import com.igloosyrup.paimonquests.enums.PasswordEnum;
import com.igloosyrup.paimonquests.services.PasswordService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private PasswordService passwordService;

    public WebSecurityConfigurer() {
        this.passwordService = new PasswordService(PasswordEnum.PBKDF2.getStringValue());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//        .csrf().disable();
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**", "index", "/css/*", "/js/*", "/user/login", "/user/register", "/admin/login").permitAll()
//                .antMatchers("/user/**").hasRole(USER.name())
//                .antMatchers("/user/**").hasAnyRole(ADMIN.name(), USER.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

    }
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails newUser = User.builder()
//                .username("potataTo1!")
//                .password(passwordService.encodePassword("potataTo1!"))
//                .authorities(USER.getGrantedAuthorities())
////                .roles(ApplicationUserRole.USER.name()) // ROLE_USER
//                .build();

//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordService.encodePassword("admin"))
//                .authorities(ADMIN.getGrantedAuthorities())
//                .roles(ApplicationUserRole.ADMIN.name()) // ROLE_ADMIN
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                newUser, admin
//        );
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("http://localhost:4000/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
}
