package ru.rti.inform.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
