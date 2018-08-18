package repository;

import entity.Occurrence;
import org.springframework.data.repository.CrudRepository;

public interface OccurrenceRepository extends CrudRepository<Occurrence, Long> {
}
