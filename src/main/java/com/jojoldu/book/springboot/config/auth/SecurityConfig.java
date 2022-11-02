package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**",
                        "/js/**","/h2-console/**", "/hanip", "/information", "/program", "/reservation", "/qna").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .antMatchers("/hanip-manager", "program-save", "/api/v1/**").hasRole(Role.MANAGER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/hanip")
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/hanip")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
