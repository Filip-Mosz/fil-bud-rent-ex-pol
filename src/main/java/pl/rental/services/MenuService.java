package pl.rental.services;

import org.springframework.stereotype.Service;
import pl.rental.dtos.MenuDto;

import java.util.List;

@Service
public class MenuService {

    public List<MenuDto> getMenu() {
        return List.of(
                new MenuDto("Home", "/index"),
                new MenuDto("Wynajem", "/rents"),
                new MenuDto("Zwroty", "/returns"),
                new MenuDto("O nas", "/about")
        );
    }
}
