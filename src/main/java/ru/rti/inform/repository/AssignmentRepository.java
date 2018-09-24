package ru.rti.inform.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.entity.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
}
