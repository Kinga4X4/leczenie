package pl.kinga.leczenie.uzytkownik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UzytkownikController {

    UzytkownikRepository uzytkownikRepository;

    public UzytkownikController(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }

    @GetMapping("/uzytkownik")
    public String uzytkownicy(Model model) {
        model.addAttribute("uzytkownicy", uzytkownikRepository.findAll());
        return "uzytkowicy";
    }

    @GetMapping("/uzytkownik/dodaj")
    public String addForm(Model model) {
        model.addAttribute("uzytkownik", new Uzytkownik());
        return "dodajUzytkownika";
    }

    @PostMapping("/uzytkownik/dodaj")
    public String addForm(Uzytkownik uzytkownik) {
        uzytkownikRepository.save(uzytkownik);
        return "redirect:/uzytkownik";
    }

}
