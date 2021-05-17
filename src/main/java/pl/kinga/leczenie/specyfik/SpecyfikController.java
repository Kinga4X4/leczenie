package pl.kinga.leczenie.specyfik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kinga.leczenie.sposobleczenia.SposobLeczenia;
import pl.kinga.leczenie.sposobleczenia.SposobLeczeniaRepository;

import java.util.Optional;

@Controller
public class SpecyfikController {

    SposobLeczeniaRepository sposobLeczeniaRepository;
    SpecyfikRepository specyfikRepository;

    public SpecyfikController(SposobLeczeniaRepository sposobLeczeniaRepository, SpecyfikRepository specyfikRepository) {
        this.sposobLeczeniaRepository = sposobLeczeniaRepository;
        this.specyfikRepository = specyfikRepository;
    }

    @GetMapping("/SposobLeczeniaZnajdz")
    public String metodyLeczenia(Model model, SposobLeczenia sposobLeczenia) {
        model.addAttribute("specyfik", specyfikRepository.findBySposobLeczenia(sposobLeczenia));
        return "metodyLeczenia";
    }

    @GetMapping("/specyfik/dodaj")
    public String addForm(Model model, @RequestParam Long sposobLeczeniaId) {
        Specyfik specyfik = new Specyfik();
        Optional<SposobLeczenia> sposobLeczeniaOptional = sposobLeczeniaRepository.findById(sposobLeczeniaId);
        specyfik.setSposobLeczenia(sposobLeczeniaOptional.orElse(null));
        model.addAttribute("sposobyLeczenia", sposobLeczeniaRepository.findAll());
        model.addAttribute("specyfik", new Specyfik());
        return "dodajSpecyfik";
    }

    @PostMapping("/specyfik/dodaj")
    public String addForm(Specyfik specyfik) {
        specyfikRepository.save(specyfik);
        return "redirect:/sposobLeczenia/" + specyfik.getSposobLeczenia().getId();
    }

}
