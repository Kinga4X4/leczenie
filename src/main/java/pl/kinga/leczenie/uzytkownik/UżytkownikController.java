package pl.kinga.leczenie.uzytkownik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kinga.leczenie.specyfik.Specyfik;
import pl.kinga.leczenie.sposobleczenia.SposobLeczenia;

import java.util.Optional;

@Controller
public class UżytkownikController {

    UzytkownikRepository uzytkownikRepository;

    public UżytkownikController(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }

    @GetMapping("/uzytkownik")
    public String uzytkownicy(Model model) {
        model.addAttribute("uzytkownicy", uzytkownikRepository.findAll());
        return "uzytkowicy";
    }

    @GetMapping("/uzytkownik/dodaj")
    public String addForm(Model model) {
        Uzytkownik uzytkownik = new Uzytkownik();
        model.addAttribute("uzytkownik", new Uzytkownik());
        return "dodajUzytkownika";
    }

    @PostMapping("/uzytkownik/dodaj")
    public String addForm(Uzytkownik uzytkownik) {
        uzytkownikRepository.save(uzytkownik);
        return "redirect:/uzytkownik/" + uzytkownik.getId();
    }

}
