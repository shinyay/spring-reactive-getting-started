package io.pivotal.shinyay

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest
class ReactiveGettingStartedApplicationTests {

	val logger: Logger = LoggerFactory.getLogger(this::class.java)
	val webClient: WebClient = WebClient.builder().baseUrl("http://localhost:8080").build()

	@Test
	fun testFindPersonBackPressure() {
	}

}
