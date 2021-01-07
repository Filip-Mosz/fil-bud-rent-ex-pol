package pl.rental.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import pl.rental.entities.EquipmentEntity;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class InitialDataServiceTest {

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

    @InjectMocks
    InitialDataService initial;


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
    }

    @Test
    void fillSampleEmployees() {
    }

    @Test
    void createHistory() {
    }

    @Test
    void createRental() {
    }

    @Test
    void makeUpRents() {
    }

    @Test
    void makeUpReturns() {
    }
}