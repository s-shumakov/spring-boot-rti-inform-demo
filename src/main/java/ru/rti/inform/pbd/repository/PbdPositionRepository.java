package ru.rti.inform.pbd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.pbd.entity.PbdPosition;

public interface PbdPositionRepository extends CrudRepository<PbdPosition, Long> {
}
