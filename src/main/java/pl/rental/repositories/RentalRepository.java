package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.RentalEntity;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
}
