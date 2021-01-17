package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.ReturnEntity;

import java.util.Optional;

public interface ReturnRepository extends JpaRepository<ReturnEntity, Long> {
    Optional<ReturnEntity> getAllByClientId(Long id);
}
