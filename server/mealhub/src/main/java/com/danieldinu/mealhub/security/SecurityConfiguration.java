package com.danieldinu.mealhub.security;

import com.danieldinu.mealhub.security.jwt.JwtAuthenticationEntryPoint;
import com.danieldinu.mealhub.security.jwt.JwtAuthenticationFilter;
import com.danieldinu.mealhub.security.services.JwtProviderService;
import com.danieldinu.mealhub.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    private final JwtProviderService jwtProviderService;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public SecurityConfiguration(JwtProviderService jwtProviderService, UserDetailsServiceImpl userDetailsService, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtProviderService = jwtProviderService;
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Bean
    protected DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                /*
                * Declares which URLs will have WHAT access type
                * */

                .and()
                    .authorizeRequests()
                    .antMatchers("/api/public/**", "/static/css/**", "/static/js/**", "/images/**").permitAll()
                    .antMatchers("/api/private/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/**").hasRole("ADMIN")

                    /*
                    * Any other URL unconfigured will need authentication
                    * */

                    .anyRequest().authenticated()

                    /*
                    * Form Details
                    * */

                    .and()
                        .formLogin()
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/restaurants")

                        /*
                        * LogOut Details
                        * */

                        .and()
                            .logout(
                                logout -> logout
                                    .logoutUrl("/api/public/auth/logout")
                                    .logoutSuccessUrl("/login")
                                    .invalidateHttpSession(true)
                            );

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(new JwtAuthenticationFilter(jwtProviderService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
