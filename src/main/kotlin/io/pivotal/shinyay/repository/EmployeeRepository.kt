package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.Employee
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository {

    companion object {
        init {
            val employeeData = mapOf<String, Employee>(
                    "1" to Employee("1", "Emp1"),
                    "2" to Employee("2", "Emp2"),
                    "3" to Employee("3", "Emp3"),
                    "4" to Employee("4", "Emp4"),
                    "5" to Employee("5", "Emp5")
            )

            val employeeAccessData = mapOf<String, String>(
                    "1" to "Emp1 Access Data",
                    "2" to "Emp2 Access Data",
                    "3" to "Emp3 Access Data",
                    "4" to "Emp4 Access Data",
                    "5" to "Emp5 Access Data"
                    )
        }
    }
}