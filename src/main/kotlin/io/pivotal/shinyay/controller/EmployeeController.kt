package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Employee
import io.pivotal.shinyay.repository.EmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/employees")
class EmployeeController(val employeeRepository: EmployeeRepository) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: String) = employeeRepository.findEmployeeById(id)

    @GetMapping
    fun getAllEmployees() = employeeRepository.findAllEmployees()

    @PostMapping("/update")
    fun updateEmployee(@RequestBody employee: Employee): Mono<Employee> = employeeRepository.updateEmployee(employee)
}