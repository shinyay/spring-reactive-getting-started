package io.pivotal.shinyay.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

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
}