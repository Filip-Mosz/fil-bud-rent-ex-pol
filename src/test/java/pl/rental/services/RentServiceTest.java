package pl.rental.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.rental.entities.EquipmentEntity;
import pl.rental.enums.StatusEnum;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class RentServiceTest {

    //mock creation
    @Mock
    private final RentService mockedRent = mock(RentService.class);


    @Test
    void getAvailableByBrand() {
        when(mockedRent.getAvailableByBrand("Prosperplast")).thenReturn(List.of(
                new EquipmentEntity()
                    .setStatus(StatusEnum.AVAILABLE.toString())
                    .setBrand("Prosperplast"),
                new EquipmentEntity()
                    .setStatus(StatusEnum.AVAILABLE.toString())
                    .setBrand("Prosperplast"),
                new EquipmentEntity()
                    .setStatus(StatusEnum.AVAILABLE.toString())
                    .setBrand("Prosperplast")
        ));

        //using mock object
        assertEquals(mockedRent.getAvailableByBrand("Prosperplast").size(), 3);

        //verification
        verify(mockedRent).getAvailableByBrand(any());
    }

    @Test
    void getAllAvailable() {
        when(mockedRent.getAllAvailable()).thenReturn(List.of(
                new EquipmentEntity()
                        .setStatus(StatusEnum.AVAILABLE.toString())
                        .setBrand("Prosperplast"),
                new EquipmentEntity()
                        .setStatus(StatusEnum.AVAILABLE.toString())
                        .setBrand("Prosperplast"),
                new EquipmentEntity()
                        .setStatus(StatusEnum.AVAILABLE.toString())
                        .setBrand("Prosperplast")
        ));

        assertEquals(mockedRent.getAllAvailable().size(), 3);

        verify(mockedRent).getAllAvailable();
    }
}