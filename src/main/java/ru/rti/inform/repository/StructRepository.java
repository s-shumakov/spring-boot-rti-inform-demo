package ru.rti.inform.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.entity.Struct;

public interface StructRepository extends CrudRepository<Struct, Long> {
}
