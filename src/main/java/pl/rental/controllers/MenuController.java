package pl.rental.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rental.dtos.MenuDto;
import pl.rental.services.MenuService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menu")
    public List<MenuDto> getMenuItems(Model model) {
    List<MenuDto> menuItems = menuService.getMenu();
        model.addAttribute("menuItems", menuItems);

        return menuService.getMenu();
    }


}
