package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.RentEntity;

public interface RentRepository extends JpaRepository<RentEntity, Long> {
}
