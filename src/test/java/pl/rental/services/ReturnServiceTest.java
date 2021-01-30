package pl.rental.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.rental.dtos.RentDto;
import pl.rental.dtos.ReturnDto;
import pl.rental.dtos.ReturnForm;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ReturnServiceTest {
    @Mock
    private final  ReturnService mockedReturn = mock(ReturnService.class);

//    1.kilku klientów o tych samych danych (2 ludzi)
//    1.1 jeden ma 1 wypozyczenie więcej niż zwrotów -> OK
//    1.2 obaj spełniają warunek 1.1 -> zwraca starszy wpis (rentEntity)
//    2. klient, który nic nie wypożyczył (rentservice zwraca null) -> pusty rentEntity
//    3. jeden klient -> zwraca ostatnie wyporzyczenie tego klienta
//    4. brak klienta o podanych danych -> puste returnEntity

    //    !!!Potrzebny będzie refactor pod wyniki testu!!!
//    brak funkcji tworzącej zwrot na podstawie wypożyczenia
    @Test
    void createReturnEntity() {
    }

    @Test
    void shouldReturnDaysDifference() {
        //given
// TODO: 30.01.2021 najpierw przerobić klasy, zeby korzystały z dto
// TODO: 30.01.2021 zaimplementować, żeby bylo co testować
        Date dateOfRent = Date.valueOf(LocalDate.now().minusDays(5));
        Date today = Date.valueOf(LocalDate.now());

        RentDto rentTest = new RentDto()
                .setDateOfRent(dateOfRent)
                .setEstimatedDateOfReturn(today);
        ReturnDto returnTest = new ReturnDto()
                .setRentId(rentTest)
                .setDateOfReturn(today);

        ReturnForm returnFormTest = new ReturnForm()
                .setEmployeeId(1L)
                .setRentId(rentTest.getId());
        //when
        //then
    }
}