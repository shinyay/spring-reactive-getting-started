package io.pivotal.shinyay.controller

import io.pivotal.shinyay.repository.EmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employees")
class EmployeeController(val employeeRepository: EmployeeRepository) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: String) = employeeRepository.findEmployeeById(id)
}