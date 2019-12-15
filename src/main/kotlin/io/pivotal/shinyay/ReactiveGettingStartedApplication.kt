package io.pivotal.shinyay

import io.pivotal.shinyay.client.EmployeeWebClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveGettingStartedApplication

fun main(args: Array<String>) {
	runApplication<ReactiveGettingStartedApplication>(*args)
	val employeeWebClient = EmployeeWebClient()
	employeeWebClient.consume()
}
