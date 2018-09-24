package ru.rti.inform.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rti.inform.entity.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
