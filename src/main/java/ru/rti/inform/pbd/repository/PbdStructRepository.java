package ru.rti.inform.pbd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.pbd.entity.PbdStruct;

public interface PbdStructRepository extends CrudRepository<PbdStruct, Long> {
}
