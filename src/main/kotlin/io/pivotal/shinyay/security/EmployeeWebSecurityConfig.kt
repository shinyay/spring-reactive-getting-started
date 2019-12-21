package io.pivotal.shinyay.security

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
class EmployeeWebSecurityConfig {

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService = MapReactiveUserDetailsService(
            User
                    .withUsername("admin")
                    .password(BCryptPasswordEncoder().encode("password"))
                    .roles("ADMIN")
                    .build()
    )

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        http
                .csrf()
                .disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.POST, "/employees/update")
                .hasRole("ADMIN")
                .pathMatchers("/**")
                .permitAll()
                .and()
                .httpBasic()
        return http.build()
    }
}