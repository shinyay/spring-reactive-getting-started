package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.stream.Stream

@RestController
class PersonController {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/json")
    fun findPersonJson(): Flux<Person> = Flux.fromStream(
            Stream.of(
                    Person(1, "Name01", "Surname01", 11),
                    Person(2, "Name02", "Surname02", 22),
                    Person(3, "Name03", "Surname03", 33),
                    Person(4, "Name04", "Surname04", 44),
                    Person(5, "Name05", "Surname05", 55))
    ).doOnNext { person -> logger.info("Server Produces: $person") }

    @GetMapping("/stream", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findPersonStream(): Flux<Person> = Flux.fromStream(
            Stream.of(
                    Person(6, "Name06", "Surname06", 66),
                    Person(7, "Name07", "Surname07", 77),
                    Person(8, "Name08", "Surname08", 88),
                    Person(9, "Name09", "Surname09", 99),
                    Person(10, "Name10", "Surname10", 100))
    ).delaySequence(Duration.ofMillis(1000))
            .doOnNext { person -> logger.info("Server Produces: $person") }

    @GetMapping("/backpressure", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findPersonStreamBackPressure(): Flux<Person> = Flux.fromStream(
            Stream.of(
                    Person(1, "Name01", "Surname01", 11),
                    Person(2, "Name02", "Surname02", 22),
                    Person(3, "Name03", "Surname03", 33),
                    Person(4, "Name04", "Surname04", 44),
                    Person(5, "Name05", "Surname05", 55),
                    Person(6, "Name06", "Surname06", 66),
                    Person(7, "Name07", "Surname07", 77),
                    Person(8, "Name08", "Surname08", 88),
                    Person(9, "Name09", "Surname09", 99),
                    Person(10, "Name10", "Surname10", 100))
    ).delaySequence(Duration.ofMillis(100))
            .doOnNext { person -> logger.info("Server Produces: $person") }
}