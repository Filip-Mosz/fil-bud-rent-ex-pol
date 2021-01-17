package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.ClientEntity;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findAllByNameAndSurname(String name, String surname);
}
