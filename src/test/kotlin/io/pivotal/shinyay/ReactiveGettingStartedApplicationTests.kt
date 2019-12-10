package io.pivotal.shinyay

import io.pivotal.shinyay.entity.Person
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@SpringBootTest
class ReactiveGettingStartedApplicationTests {

	val logger: Logger = LoggerFactory.getLogger(this::class.java)
	val webClient: WebClient = WebClient.builder().baseUrl("http://localhost:8080").build()

	@Test
	fun testFindPersonBackPressure() {
		var person: Flux<Person> = webClient.get().uri("/backpressure").retrieve().bodyToFlux(Person::class.java)
		person.map{Thread.sleep(90)}.subscribe { person -> logger.info("Client subscribes: $person") }
	}

}
