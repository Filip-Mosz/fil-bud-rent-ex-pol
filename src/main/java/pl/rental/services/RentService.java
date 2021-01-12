package pl.rental.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rental.entities.EquipmentEntity;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.EquipmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentService {

    private final EquipmentRepository equipmentRepository;

    public List<EquipmentEntity> getAvailableByBrand(String brand){
        return equipmentRepository.findAllByBrand(brand).stream()
        .filter(e -> e.getStatus().equals(StatusEnum.AVAILABLE.toString()))
        .collect(Collectors.toList());
    }

    public List<EquipmentEntity> getAllAvailable(){
        return equipmentRepository.findAll().stream()
                .filter(e -> e.getStatus().equals(StatusEnum.AVAILABLE.toString()))
                .collect(Collectors.toList());
    }

    public void rentEquipment(EquipmentEntity machine){
        Optional<EquipmentEntity> foundMachine = equipmentRepository.findById(machine.getId());

        EquipmentEntity rentedMachine = foundMachine.orElseGet(EquipmentEntity::new);
        rentedMachine.setStatus(StatusEnum.BORROWED.toString());
        equipmentRepository.save(rentedMachine);
    }

    public List<EquipmentEntity> getAll() {
        return equipmentRepository.findAll();
    }
}
