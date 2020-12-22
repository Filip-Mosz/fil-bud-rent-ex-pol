package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
