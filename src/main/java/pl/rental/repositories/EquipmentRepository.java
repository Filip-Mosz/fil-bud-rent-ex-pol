package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.EquipmentEntity;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
}
