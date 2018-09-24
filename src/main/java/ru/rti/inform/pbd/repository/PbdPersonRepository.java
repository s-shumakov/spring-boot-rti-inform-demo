package ru.rti.inform.pbd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.pbd.entity.PbdPerson;

public interface PbdPersonRepository extends CrudRepository<PbdPerson, Long> {
}
