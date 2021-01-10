package pl.rental.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import pl.rental.entities.*;
import pl.rental.enums.PositionEnum;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.*;

import java.sql.Date;
import java.util.LinkedList;

import static org.mockito.Mockito.*;

@SuppressWarnings({"deprecation"})
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class InitialDataServiceTest {

    // TODO: 09.01.2021 refactor to integration test, just as i understand how

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EquipmentRepository equipmentRepository;
    @Mock
    private RentalRepository rentalRepository;
    @Mock
    private RentRepository rentRepository;
    @Mock
    private ReturnRepository returnRepository;

    //    @InjectMocks
    InitialDataService initial;

    @BeforeEach
    public void setUp() {
        this.initial = new InitialDataService(clientRepository, employeeRepository, equipmentRepository, rentalRepository, rentRepository, returnRepository);
    }

    @Test
    void run() {
    }

    @Test
    void fillSampleEquipment() {
        //there should be such equipments used in method
        //3 times
        EquipmentEntity equ0 = new EquipmentEntity()
                .setBrand("Makiła")
                .setModel("Pan Twardeusz")
                .setType("Zagęszczarka do betonu")
                .setPrizeForDay(50L)
                .setStatus(StatusEnum.AVAILABLE.toString());
        //1 time
        EquipmentEntity equ1 = new EquipmentEntity()
                .setBrand("Altrad")
                .setModel("Expert 130K")
                .setType("Betoniarka")
                .setPrizeForDay(100L)
                .setStatus(StatusEnum.AVAILABLE.toString());
        //4 times
        EquipmentEntity equ2 = new EquipmentEntity()
                .setBrand("Prosperplast")
                .setModel("Wiadro z lejkiem 15l")
                .setType("Wiadro")
                .setPrizeForDay(5L)
                .setStatus(StatusEnum.AVAILABLE.toString());
        //2 times
        EquipmentEntity equ3 = new EquipmentEntity()
                .setBrand("NoName")
                .setModel("Taczka budowlana")
                .setType("Taczka")
                .setPrizeForDay(15L)
                .setStatus(StatusEnum.AVAILABLE.toString());

        initial.fillSampleEquipment();

        verify(equipmentRepository, times(3)).save(equ0);
        verify(equipmentRepository, times(1)).save(equ1);
        verify(equipmentRepository, times(4)).save(equ2);
        verify(equipmentRepository, times(2)).save(equ3);
    }

    @Test
    void fillSampleClients() {
        ClientEntity client = new ClientEntity()
                .setName("Maksymilian")
                .setSurname("Habsburg")
                .setEmail("cesar@holyromanempire.de")
                .setAddress("Zamek Habsburg")
                .setCompany("Swiete Cesarstwo Rzymskie narodu niemieckiego");

        initial.fillSampleClients();

        verify(clientRepository).save(client);
    }

    @Test
    void fillSampleEmployees() {
        EmployeeEntity emp = new EmployeeEntity()
                .setName("Janina")
                .setSurname("Kowalska")
                .setPosition(PositionEnum.CEO.toString());

        when(employeeRepository.save(eq(emp))).thenReturn(emp);

        initial.fillSampleEmployees();

        verify(employeeRepository).save(emp);
    }

    @Test
    void createHistory() throws Exception {
        RentEntity rent3 = new RentEntity()
                .setMachineId(new EquipmentEntity()
                        .setBrand("Prosperplast")
                        .setModel("Wiadro z lejkiem 15l")
                        .setType("Wiadro")
                        .setPrizeForDay(5L)
                        .setStatus(StatusEnum.AVAILABLE.toString()))
                .setClientId(new ClientEntity()
                        .setName("Stefan")
                        .setSurname("Batory")
                        .setEmail("krol@rzplita.pl")
                        .setAddress("Wawel")
                        .setCompany("Rzeczpospolita Obojga Narodów"))
                .setEmployeeId(new EmployeeEntity()
                        .setName("Jacek")
                        .setSurname("Kaczmarski")
                        .setPosition(PositionEnum.MANAGER.toString()))
                .setDateOfRent(new Date(120, 10, 10))
                .setEstimatedDateOfReturn(new Date(120, 10, 11));
        ReturnEntity returnEntity3 = new ReturnEntity()
                .setEmployeeId(new EmployeeEntity()
                        .setName("Jacek")
                        .setSurname("Kaczmarski")
                        .setPosition(PositionEnum.MANAGER.toString()))
                .setClientId(new ClientEntity()
                        .setName("Stefan")
                        .setSurname("Batory")
                        .setEmail("krol@rzplita.pl")
                        .setAddress("Wawel")
                        .setCompany("Rzeczpospolita Obojga Narodów"))
                .setMachineId(new EquipmentEntity()
                        .setBrand("Prosperplast")
                        .setModel("Wiadro z lejkiem 15l")
                        .setType("Wiadro")
                        .setPrizeForDay(5L)
                        .setStatus(StatusEnum.AVAILABLE.toString()))
                .setDateOfReturn(new Date(120, 10, 11))
                .setRentId(rent3)
                .setDelayInDays(0L);

        initial.run();

        verify(returnRepository, times(10)).save(any());
    }

    @Test
    void createRental() throws Exception {

        EmployeeEntity emp0 = new EmployeeEntity()
                .setName("Janina")
                .setSurname("Kowalska")
                .setPosition(PositionEnum.CEO.toString());
        EmployeeEntity emp1 = new EmployeeEntity()
                .setName("Jacek")
                .setSurname("Kaczmarski")
                .setPosition(PositionEnum.MANAGER.toString());
        EmployeeEntity emp2 = new EmployeeEntity()
                .setName("Grzegorz")
                .setSurname("Brzeczyszczykiewicz")
                .setPosition(PositionEnum.REGULAR.toString());

        LinkedList<EmployeeEntity> employees = new LinkedList<>();
        employees.add(emp0);
        employees.add(emp1);
        employees.add(emp2);

        RentalEntity mainRental = new RentalEntity()
                .setCeo(employees.get(0))
                .setCompanyName("Fil-Bud-Rent-Ex-Pol")
                .setAddress("ul. Budowlana 0, 00-000 Wygwizdów")
                .setEmployees(employees)
                .setWebsite("www.filbudrentexpol.com.pl");

        initial.run();

        verify(rentalRepository).save(any());
    }

    @Test
    void makeUpRents() throws Exception {
        RentEntity rent3 = new RentEntity()
                .setMachineId(new EquipmentEntity()
                        .setBrand("Prosperplast")
                        .setModel("Wiadro z lejkiem 15l")
                        .setType("Wiadro")
                        .setPrizeForDay(5L)
                        .setStatus(StatusEnum.AVAILABLE.toString()))
                .setClientId(new ClientEntity()
                        .setName("Stefan")
                        .setSurname("Batory")
                        .setEmail("krol@rzplita.pl")
                        .setAddress("Wawel")
                        .setCompany("Rzeczpospolita Obojga Narodów"))
                .setEmployeeId(new EmployeeEntity()
                        .setName("Jacek")
                        .setSurname("Kaczmarski")
                        .setPosition(PositionEnum.MANAGER.toString()))
                .setDateOfRent(new Date(120, 10, 10))
                .setEstimatedDateOfReturn(new Date(120, 10, 11));

        initial.run();

        verify(rentRepository, times(11)).save(any());
    }
}