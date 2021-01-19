package pl.rental.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    //    1.kilku klientów o tych samych danych (2 ludzi)
//    1.1 jeden ma 1 wypozyczenie więcej niż zwrotów -> OK
//    1.2 obaj spełniają warunek 1.1 -> zwraca starszy wpis (rentEntity)
//    2. klient, który nic nie wypożyczył (rentservice zwraca null) -> pusty rentEntity
//    3. jeden klient -> zwraca ostatnie wyporzyczenie tego klienta
//    4. brak klienta o podanych danych -> puste returnEntity

    //    !!!Potrzebny będzie refactor pod wyniki testu!!!
//    brak funkcji tworzącej zwrot na podstawie wypożyczenia

    @Test
    void shouldReturnClient() {

    }
}