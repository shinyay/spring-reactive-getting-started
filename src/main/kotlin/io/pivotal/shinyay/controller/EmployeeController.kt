package io.pivotal.shinyay.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employees")
class EmployeeController {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)
}