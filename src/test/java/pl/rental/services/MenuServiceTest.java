package pl.rental.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {

    @Test
    void getMenu() {
//        given
        MenuService service = new MenuService();
//        when

//        then
        assertEquals(service.getMenu().get(0).getName(), "Home");
    }
}