package pl.rental.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rental.dtos.EquipmentDto;
import pl.rental.dtos.RentForm;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.EquipmentEntity;
import pl.rental.entities.RentEntity;
import pl.rental.enums.StatusEnum;
import pl.rental.mappers.EquipmentMapper;
import pl.rental.repositories.ClientRepository;
import pl.rental.repositories.EmployeeRepository;
import pl.rental.repositories.EquipmentRepository;
import pl.rental.repositories.RentRepository;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentService {
    // TODO: 22.01.2021 UNIT TESTS

    private final EquipmentRepository equipmentRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final RentRepository rentRepository;



    public List<EquipmentDto> getAvailableByBrand(String brand) { //probably redundant
        List<EquipmentEntity> availableEntities = equipmentRepository.findAllByBrand(brand).stream()
                .filter(e -> e.getStatus().equals(StatusEnum.AVAILABLE.toString()))
                .collect(Collectors.toList());

        List<EquipmentDto> availableDtos = new LinkedList<>();
        for (EquipmentEntity availableEntity : availableEntities) {
            availableDtos.add(EquipmentMapper.toDto(availableEntity));
        }

        return availableDtos;
    }

    public List<EquipmentEntity> getAllAvailable() { //probably redundant
        return equipmentRepository.findAll().stream()
                .filter(e -> e.getStatus().equals(StatusEnum.AVAILABLE.toString()))
                .collect(Collectors.toList());
    }

    public void rentEquipment(EquipmentEntity machine) {
        Optional<EquipmentEntity> foundMachine = equipmentRepository.findById(machine.getId());

        EquipmentEntity rentedMachine = foundMachine.orElseGet(EquipmentEntity::new);
        rentedMachine.setStatus(StatusEnum.BORROWED.toString());
        equipmentRepository.save(rentedMachine);
    }

    public List<EquipmentDto> getAll() {

        List<EquipmentEntity> listEntity = equipmentRepository.findAll();

        List<EquipmentDto> listDto = new LinkedList<>();
        for (EquipmentEntity availableEntity : listEntity) {
            listDto.add(EquipmentMapper.toDto(availableEntity));
        }

        return listDto;
    }

    public RentEntity createRent(RentForm rentForm) {
        Optional<EquipmentEntity> machineId = equipmentRepository.findById(rentForm.getEquipmentId());
        Date estDate = Date.valueOf(rentForm.getEstimatedDateOfReturn());
        Optional<ClientEntity> clientId = clientRepository.findById(rentForm.getClientId());
        Optional<EmployeeEntity> employeeId = employeeRepository.findById(rentForm.getEmployeeId());

        machineId.ifPresent(this::rentEquipment);

        return rentRepository.save(new RentEntity()
                .setMachineId(machineId.orElse(new EquipmentEntity()))
                .setEstimatedDateOfReturn(estDate)
                .setDateOfRent(rentForm.getDateOfRent())
                .setClientId(clientId.orElse(new ClientEntity()))
                .setEmployeeId(employeeId.orElse(new EmployeeEntity())));
    }
}
