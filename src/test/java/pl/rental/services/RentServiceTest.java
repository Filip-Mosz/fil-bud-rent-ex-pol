package pl.rental.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.rental.entities.EquipmentEntity;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
class RentServiceTest {

    @Mock
    private RentService rentService;
    //mock creation
    RentService mockedService = mock(RentService.class);


//    @Test
//    void getAvailableByBrand() {
//        List mockedList = mock(List.class);
//        when(anyList().size()).thenReturn(3);
//
//        //using mock object
//        mockedService.getAvailableByBrand("Prosperplast");
//
//        //verification
//        verify(mockedService).getAvailableByBrand("Prosperplast");
////        when(mockedService.getAvailableByBrand("Prosperplast")).thenReturn(mockedList);
//    }
}