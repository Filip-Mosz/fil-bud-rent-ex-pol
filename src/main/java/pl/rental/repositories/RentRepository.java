package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.RentEntity;

import java.util.Optional;

public interface RentRepository extends JpaRepository<RentEntity, Long> {
    Optional<RentEntity> getAllByClientId(Long id);
}
