package ru.rti.inform.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
