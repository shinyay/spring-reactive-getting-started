package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Employee
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
    fun findPersonJson(): Flux<Employee> = Flux.fromStream(
            Stream.of(
                    Employee(1, "Name01", "Surname01", 11),
                    Employee(2, "Name02", "Surname02", 22),
                    Employee(3, "Name03", "Surname03", 33),
                    Employee(4, "Name04", "Surname04", 44),
                    Employee(5, "Name05", "Surname05", 55))
    ).doOnNext { person -> logger.info("Server Produces: $person") }

    @GetMapping("/stream", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findPersonStream(): Flux<Employee> = Flux.fromStream(
            Stream.of(
                    Employee(6, "Name06", "Surname06", 66),
                    Employee(7, "Name07", "Surname07", 77),
                    Employee(8, "Name08", "Surname08", 88),
                    Employee(9, "Name09", "Surname09", 99),
                    Employee(10, "Name10", "Surname10", 100))
    ).delaySequence(Duration.ofMillis(1000))
            .doOnNext { person -> logger.info("Server Produces: $person") }

    @GetMapping("/backpressure", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findPersonStreamBackPressure(): Flux<Employee> = Flux.fromStream(
            Stream.of(
                    Employee(1, "Name01", "Surname01", 11),
                    Employee(2, "Name02", "Surname02", 22),
                    Employee(3, "Name03", "Surname03", 33),
                    Employee(4, "Name04", "Surname04", 44),
                    Employee(5, "Name05", "Surname05", 55),
                    Employee(6, "Name06", "Surname06", 66),
                    Employee(7, "Name07", "Surname07", 77),
                    Employee(8, "Name08", "Surname08", 88),
                    Employee(9, "Name09", "Surname09", 99),
                    Employee(10, "Name10", "Surname10", 100))
    ).delaySequence(Duration.ofMillis(100))
            .doOnNext { person -> logger.info("Server Produces: $person") }
}