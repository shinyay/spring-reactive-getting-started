package io.pivotal.shinyay.client

import io.pivotal.shinyay.entity.Employee
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class EmployeeWebClient {

    private val client:WebClient = WebClient.create("http://localhost:8080")

    fun consume() {
        val employeeMono: Mono<Employee> = client.get()
                .uri("/employees/{id}", 1)
                .retrieve()
                .bodyToMono(Employee::class.java)
        employeeMono.subscribe(System.out::println)

        val employeeFlux: Flux<Employee> = client.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee::class.java)
        employeeFlux.subscribe(System.out::println)
    }
}