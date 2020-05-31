/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.springboot.vuejs.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
/**
 *
 * @author lorenzo
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().disable()
                .addHeaderWriter(
                        new StaticHeadersWriter("X-FRAME-OPTIONS", "ALLOW-FROM com.llh.springboot.vuejs"))
                .and()
                .authorizeRequests()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/frontend2").permitAll()
                .antMatchers("/api/user/**").authenticated()
                .antMatchers("/api/secured").authenticated()
                .and()
                .csrf().disable();
    }

}
