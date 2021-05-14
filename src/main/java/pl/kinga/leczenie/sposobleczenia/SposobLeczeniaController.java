package pl.kinga.leczenie.sposobleczenia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class SposobLeczeniaController {

    private SposobLeczeniaRepository sposobLeczeniaRepository;

    public SposobLeczeniaController(SposobLeczeniaRepository sposobLeczeniaRepository) {
        this.sposobLeczeniaRepository = sposobLeczeniaRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/metodyLeczenia")
    public String metodyLeczenia(Model model) {
        model.addAttribute("sposobyLeczenia", sposobLeczeniaRepository.findAll());
        return "metodyLeczenia";
    }

    @GetMapping("/sposobLeczenia/{id}")
    public String sposobLeczenia(@PathVariable Long id, Model model) {
        Optional<SposobLeczenia> sposobLeczeniaOptional = sposobLeczeniaRepository.findById(id);
        if (sposobLeczeniaOptional.isPresent()) {
            SposobLeczenia sposobLeczenia = sposobLeczeniaOptional.get();
            model.addAttribute("sposobLeczenia", sposobLeczenia);
            return "sposobLeczenia";
        } else {
            return "error";
        }
    }

    @GetMapping("/sposobLeczenia/usun/{id}")
    public String usun(@PathVariable Long id) {
        sposobLeczeniaRepository.deleteById(id);
        return "redirect:/";
    }

}