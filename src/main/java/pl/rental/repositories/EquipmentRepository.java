package pl.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rental.entities.EquipmentEntity;

import java.util.Collection;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    List<EquipmentEntity> findAllByBrand(String brand);

//    List<EquipmentEntity> getAll();
}
