package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.ReturnEntity;

public interface ReturnRepository extends JpaRepository<ReturnEntity, Long> {
}
