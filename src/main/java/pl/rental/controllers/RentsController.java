package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rental.dtos.RentForm;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.EquipmentEntity;
import pl.rental.entities.RentEntity;
import pl.rental.repositories.ClientRepository;
import pl.rental.repositories.EmployeeRepository;
import pl.rental.repositories.EquipmentRepository;
import pl.rental.repositories.RentRepository;
import pl.rental.services.ClientService;
import pl.rental.services.RentService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class RentsController {

    public RentsController(RentService rentService, ClientService clientService, RentRepository rentRepository, EquipmentRepository equipmentRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.rentService = rentService;
        this.clientService = clientService;
        this.rentRepository = rentRepository;
        this.equipmentRepository = equipmentRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    private final ClientService clientService;
    private final RentService rentService;
    private final RentRepository rentRepository;
    private final EquipmentRepository equipmentRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    ClientEntity chosenClient = new ClientEntity()
            .setId(404L)
            .setAddress("Neverland")
            .setName("Peter")
            .setSurname("Pan");

    @GetMapping("/rents")
    public String getRents(Model model, RentForm rentForm) {

        List<EquipmentEntity> machines = rentService.getAll();

        model.addAttribute("rentForm", rentForm);
        model.addAttribute("equipments", machines);
//        chosenClient ma tu właściwe wartości
        model.addAttribute("client", chosenClient);

        return "/rents";
    }

    @PostMapping("/rents") //delete candidate
    public RentForm findClient( RentForm rentForm, Model model) {
        model.addAttribute("rentForm", rentForm);
        this.chosenClient = clientService.identifyClient(rentForm);
//        właściwie wchodzi z formularza
        return rentForm;
    }

//        // TODO: 19.01.2021 wygenerować rentEntity na podstronie odpowiadającej id wypozyczenia
//    @GetMapping("/rents/{id}}")
//    public String getSingleRent(@PathVariable("id") RentForm rentForm, String id, Model model) {
//        RentEntity newRent = createRent(rentForm);
//
//        Optional<RentEntity> singleRent = rentRepository.findById(Long.getLong(id));
////todo tu pracuję -> trzeba tak zaczarować, żeby thymeleaf miał z czego wygenerowac dane wypożyczenia
//        model.addAttribute("rent", singleRent);
//        return "rent";
//    }

    private RentEntity createRent(RentForm rentForm) {
        Optional<EquipmentEntity> machineId = equipmentRepository.findById(rentForm.getEquipmentId());
        Date estDate = Date.valueOf(rentForm.getEstimatedDateOfReturn());
        Optional<ClientEntity> clientId = clientRepository.findById(rentForm.getClientId());
        Optional<EmployeeEntity> employeeId = employeeRepository.findById(rentForm.getEmployeeId());

        return new RentEntity()
                .setMachineId(machineId.orElse(new EquipmentEntity()))
                .setEstimatedDateOfReturn(estDate)
                .setDateOfRent(rentForm.getDateOfRent())
                .setClientId(clientId.orElse(new ClientEntity()))
                .setEmployeeId(employeeId.orElse(new EmployeeEntity()))
                ;
    }
}
