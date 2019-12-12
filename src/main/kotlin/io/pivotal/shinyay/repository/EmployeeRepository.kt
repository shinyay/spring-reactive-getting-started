package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.Employee
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository {

    companion object {
        init {
            val employeeData = mapOf<String, Employee>()
        }
    }
}