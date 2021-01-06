package pl.rental.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.rental.entities.*;
import pl.rental.enums.PositionEnum;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;


@SuppressWarnings("ALL")
@Service
@RequiredArgsConstructor
@Log4j2
public class InitialDataService implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final EquipmentRepository equipmentRepository;
    private final RentalRepository rentalRepository;
    private final RentRepository rentRepository;
    private final ReturnRepository returnRepository;


    List<ClientEntity> clients = new LinkedList<>();
    List<EmployeeEntity> employees = new LinkedList<>();
    List<RentEntity> rents = new LinkedList<>();
    List<ReturnEntity> returns = new LinkedList<>();
    List<EquipmentEntity> equipments = new LinkedList<>();
    RentalEntity mainRental;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        fillSampleClients();
        fillSampleEmployees();
        fillSampleEquipment();
        createRental();
        createHistory();
    }

    void fillSampleEquipment() {
        log.info("Creating Equipment");

        EquipmentEntity equ0 = new EquipmentEntity()
                .setBrand("Makiła")
                .setModel("Pan Twardeusz")
                .setType("Zagęszczarka do betonu")
                .setPrizeForDay(50L)
                .setStatus(StatusEnum.AVAILABLE.toString());
        EquipmentEntity equ1 = new EquipmentEntity()
                .setBrand("Altrad")
                .setModel("Expert 130K")
                .setType("Betoniarka")
                .setPrizeForDay(100L)
                .setStatus(StatusEnum.AVAILABLE.toString());
        EquipmentEntity equ2 = new EquipmentEntity()
                .setBrand("Prosperplast")
                .setModel("Wiadro z lejkiem 15l")
                .setType("Wiadro")
                .setPrizeForDay(5L)
                .setStatus(StatusEnum.AVAILABLE.toString());
        EquipmentEntity equ3 = new EquipmentEntity()
                .setBrand("NoName")
                .setModel("Taczka budowlana")
                .setType("Taczka")
                .setPrizeForDay(15L)
                .setStatus(StatusEnum.AVAILABLE.toString());

        initiateEquipment(equ0);
        initiateEquipment(equ0);
        initiateEquipment(equ0);
        initiateEquipment(equ1);
        initiateEquipment(equ2);
        initiateEquipment(equ2);
        initiateEquipment(equ2);
        initiateEquipment(equ2);
        initiateEquipment(equ3);
        initiateEquipment(equ3);
    }

    void fillSampleClients() {
        log.info("Creating some sample clients");
        ClientEntity clientUnregistered = new ClientEntity()
                .setName("NONE")
                .setSurname("NONE")
                .setEmail("NONE")
                .setAddress("NONE")
                .setCompany("NONE");
        initiateClients(clientUnregistered);

        ClientEntity client1 = new ClientEntity()
                .setName("Jan")
                .setSurname("Kowalski")
                .setEmail("jkowalski@host.com")
                .setAddress("Pcim")
                .setCompany("");
        initiateClients(client1);

        ClientEntity client2 = new ClientEntity()
                .setName("Katarzyna")
                .setSurname("Caryca")
                .setEmail("caryca@kreml.moskwa.ru")
                .setAddress("Kreml moskiewski")
                .setCompany("Carat Rosyjski");
        initiateClients(client2);

        ClientEntity client3 = new ClientEntity()
                .setName("Stefan")
                .setSurname("Batory")
                .setEmail("krol@rzplita.pl")
                .setAddress("Wawel")
                .setCompany("Rzeczpospolita Obojga Narodów");
        initiateClients(client3);

        ClientEntity client4 = new ClientEntity()
                .setName("Jadwiga")
                .setSurname("Andegawenska")
                .setEmail("krol-owa@korona.pl")
                .setAddress("Wawel")
                .setCompany("Krolestwo Polskie");
        initiateClients(client4);

        ClientEntity client5 = new ClientEntity()
                .setName("Maksymilian")
                .setSurname("Habsburg")
                .setEmail("cesar@holyromanempire.de")
                .setAddress("Zamek Habsburg")
                .setCompany("Swiete Cesarstwo Rzymskie narodu niemieckiego");
        initiateClients(client5);

        ClientEntity client6 = new ClientEntity()
                .setName("Ludwik")
                .setSurname("Burbon")
                .setEmail("roisoleil@versailles.fr")
                .setAddress("Wersal")
                .setCompany("Krolestwo Francji");
        initiateClients(client6);
    }

    void fillSampleEmployees() {
        log.info("Creating employees");

        EmployeeEntity emp0 = new EmployeeEntity()
                .setName("Janina")
                .setSurname("Kowalska")
                .setPosition(PositionEnum.CEO.toString());
        initiateEmployees(emp0);

        EmployeeEntity emp1 = new EmployeeEntity()
                .setName("Jacek")
                .setSurname("Kaczmarski")
                .setPosition(PositionEnum.MANAGER.toString());
        initiateEmployees(emp1);

        EmployeeEntity emp2 = new EmployeeEntity()
                .setName("Grzegorz")
                .setSurname("Brzeczyszczykiewicz")
                .setPosition(PositionEnum.REGULAR.toString());
        initiateEmployees(emp2);
    }

    void createHistory() {
        log.info("Creating history");
        makeUpRents();
        makeUpReturns();
    }

    void createRental() {
        log.info("Creating Main Rental");

        mainRental = new RentalEntity()
                .setCeo(employees.get(0))
                .setCompanyName("Fil-Bud-Rent-Ex-Pol")
                .setAddress("ul. Budowlana 0, 00-000 Wygwizdów")
                .setEmployees(employees)
                .setWebsite("www.filbudrentexpol.com.pl");

        rentalRepository.save(mainRental);
    }

    void makeUpRents() {
        log.info("Making up rents history");

        RentEntity rent0 = new RentEntity()
                .setMachineId(equipments.get(0))
                .setClientId(clients.get(0))
                .setEmployeeId(employees.get(0))
                .setDateOfRent(new Date(120,10,2))
                .setEstimatedDateOfReturn(new Date(120,10,5));
        initiateRents(rent0);

        RentEntity rent1 = new RentEntity()
                .setMachineId(equipments.get(1))
                .setClientId(clients.get(2))
                .setEmployeeId(employees.get(1))
                .setDateOfRent(new Date(120,10,2))
                .setEstimatedDateOfReturn(new Date(120,10,4));
        initiateRents(rent1);

        RentEntity rent2 = new RentEntity()
                .setMachineId(equipments.get(2))
                .setClientId(clients.get(1))
                .setEmployeeId(employees.get(2))
                .setDateOfRent(new Date(120,10,8))
                .setEstimatedDateOfReturn(new Date(120,10,10));
        initiateRents(rent2);

        RentEntity rent3 = new RentEntity()
                .setMachineId(equipments.get(3))
                .setClientId(clients.get(3))
                .setEmployeeId(employees.get(1))
                .setDateOfRent(new Date(120,10,10))
                .setEstimatedDateOfReturn(new Date(120,10,11));
        initiateRents(rent3);

        RentEntity rent4 = new RentEntity()
                .setMachineId(equipments.get(4))
                .setClientId(clients.get(4))
                .setEmployeeId(employees.get(2))
                .setDateOfRent(new Date(120,10,3))
                .setEstimatedDateOfReturn(new Date(120,10,8));
        initiateRents(rent4);

        RentEntity rent5 = new RentEntity()
                .setMachineId(equipments.get(5))
                .setClientId(clients.get(5))
                .setEmployeeId(employees.get(1))
                .setDateOfRent(new Date(120,10,7))
                .setEstimatedDateOfReturn(new Date(120,10, 10));
        initiateRents(rent5);

        RentEntity rent6 = new RentEntity()
                .setMachineId(equipments.get(6))
                .setClientId(clients.get(6))
                .setEmployeeId(employees.get(1))
                .setDateOfRent(new Date(120, 10, 8))
                .setEstimatedDateOfReturn(new Date(120, 10, 10));
        initiateRents(rent6);

        RentEntity rent7 = new RentEntity()
                .setMachineId(equipments.get(7))
                .setClientId(clients.get(0))
                .setEmployeeId(employees.get(0))
                .setDateOfRent(new Date(120, 10, 11))
                .setEstimatedDateOfReturn(new Date(120, 10, 14));
        initiateRents(rent7);

        RentEntity rent8 = new RentEntity()
                .setMachineId(equipments.get(8))
                .setClientId(clients.get(1))
                .setEmployeeId(employees.get(1))
                .setDateOfRent(new Date(120, 10, 14))
                .setEstimatedDateOfReturn(new Date(120, 10, 17));
        initiateRents(rent8);

        RentEntity rent9 = new RentEntity()
                .setMachineId(equipments.get(0))
                .setClientId(clients.get(2))
                .setEmployeeId(employees.get(1))
                .setDateOfRent(new Date(120, 10, 17))
                .setEstimatedDateOfReturn(new Date(120, 10, 19));
        initiateRents(rent9);

        RentEntity rent10 = new RentEntity()
                .setMachineId(equipments.get(1))
                .setClientId(clients.get(3))
                .setEmployeeId(employees.get(2))
                .setDateOfRent(new Date(120, 10, 20))
                .setEstimatedDateOfReturn(new Date(120, 10, 24));
        initiateRents(rent10);
    }

    void makeUpReturns() {
        log.info("Making up returns history");

        ReturnEntity returnEntity0 = new ReturnEntity()
                .setEmployeeId(employees.get(1))
                .setClientId(clients.get(0))
                .setMachineId(equipments.get(0))
                .setDateOfReturn(new Date(120,10,5))
                .setDelayInDays(0L);
        initiateReturns(returnEntity0);

        ReturnEntity returnEntity1 = new ReturnEntity()
                .setEmployeeId(employees.get(0))
                .setClientId(clients.get(1))
                .setMachineId(equipments.get(1))
                .setDateOfReturn(new Date(120,10,5))
                .setDelayInDays(1L);
        initiateReturns(returnEntity1);

        ReturnEntity returnEntity2 = new ReturnEntity()
                .setEmployeeId(employees.get(1))
                .setClientId(clients.get(2))
                .setMachineId(equipments.get(2))
                .setDateOfReturn(new Date(120,10,10))
                .setDelayInDays(0L);
        initiateReturns(returnEntity2);

        ReturnEntity returnEntity3 = new ReturnEntity()
                .setEmployeeId(employees.get(1))
                .setClientId(clients.get(3))
                .setMachineId(equipments.get(3))
                .setDateOfReturn(new Date(120,10,11))
                .setDelayInDays(0L);
        initiateReturns(returnEntity3);

        ReturnEntity returnEntity4 = new ReturnEntity()
                .setEmployeeId(employees.get(2))
                .setClientId(clients.get(4))
                .setMachineId(equipments.get(4))
                .setDateOfReturn(new Date(120,10,8))
                .setDelayInDays(0L);
        initiateReturns(returnEntity4);

        ReturnEntity returnEntity5 = new ReturnEntity()
                .setEmployeeId(employees.get(1))
                .setClientId(clients.get(5))
                .setMachineId(equipments.get(5))
                .setDateOfReturn(new Date(120,10, 15))
                .setDelayInDays(5L);
        initiateReturns(returnEntity5);

        ReturnEntity returnEntity6 = new ReturnEntity()
                .setEmployeeId(employees.get(1))
                .setClientId(clients.get(6))
                .setMachineId(equipments.get(6))
                .setDateOfReturn(new Date(120, 10, 10))
                .setDelayInDays(0L);
        initiateReturns(returnEntity6);

        ReturnEntity returnEntity7 = new ReturnEntity()
                .setEmployeeId(employees.get(2))
                .setClientId(clients.get(0))
                .setMachineId(equipments.get(7))
                .setDateOfReturn(new Date(120, 10, 14))
                .setDelayInDays(0L);
        initiateReturns(returnEntity7);

        ReturnEntity returnEntity8 = new ReturnEntity()
                .setEmployeeId(employees.get(1))
                .setClientId(clients.get(1))
                .setMachineId(equipments.get(8))
                .setDateOfReturn(new Date(120, 10, 17))
                .setDelayInDays(0l);
        initiateReturns(returnEntity8);

        ReturnEntity returnEntity9 = new ReturnEntity()
                .setEmployeeId(employees.get(0))
                .setClientId(clients.get(2))
                .setMachineId(equipments.get(0))
                .setDateOfReturn(new Date(120, 10, 19))
                .setDelayInDays(0L);
        initiateReturns(returnEntity9);


    }

    private void initiateClients(ClientEntity client) {
        clients.add(client);
        clientRepository.save(client);
        System.out.println(client.toString());
    }

    private void initiateEmployees(EmployeeEntity employee) {
        employeeRepository.save(employee);
        employees.add(employee);
    }

    private void initiateRents(RentEntity rent) {
        rentRepository.save(rent);
        rents.add(rent);
    }

    private void initiateReturns(ReturnEntity returnEntity) {
        returnRepository.save(returnEntity);
        returns.add(returnEntity);
    }

    private void initiateEquipment(EquipmentEntity machine) {
        equipmentRepository.save(machine);
        equipments.add(machine);
    }
}
