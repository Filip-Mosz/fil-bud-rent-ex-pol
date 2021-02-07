package pl.rental.services;

import org.junit.jupiter.api.Test;
import pl.rental.dtos.RentDto;
import pl.rental.dtos.ReturnDto;
import pl.rental.dtos.ReturnForm;

import java.sql.Date;
import java.time.LocalDate;

public class PaymentServiceTest {

    @Test
    void shouldReturnDaysDifference() { //test dla PaymentService'u
        //given
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
