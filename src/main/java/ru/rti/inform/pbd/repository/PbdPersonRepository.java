package ru.rti.inform.pbd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.pbd.PbdPerson;

public interface PbdPersonRepository extends CrudRepository<PbdPerson, Integer> {
}
