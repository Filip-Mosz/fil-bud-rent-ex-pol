package pl.rental.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rental.entities.EquipmentEntity;
import pl.rental.entities.RentEntity;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.EquipmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentService {

    private final EquipmentRepository equipmentRepository;

//    public List<EquipmentEntity> getAvailableByBrand(String brand){
//        return equipmentRepository.getAllByBrand(brand).stream()
//        .filter(e -> e.getStatus().equals(StatusEnum.AVAILABLE.toString()))
//        .collect(Collectors.toList());
//    }
//
//    public List<EquipmentEntity> getAllAvailable(){
//        return equipmentRepository.getAll().stream()
//                .filter(e -> e.getStatus().equals(StatusEnum.AVAILABLE.toString()))
//                .collect(Collectors.toList());
//    }

}
