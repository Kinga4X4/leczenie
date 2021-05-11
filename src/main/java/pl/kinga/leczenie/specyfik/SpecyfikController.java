package pl.kinga.leczenie.specyfik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kinga.leczenie.sposobleczenia.SposobLeczenia;
import pl.kinga.leczenie.sposobleczenia.SposobLeczeniaRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class SpecyfikController {
    private SpecyfikRepository specyfikRepository;
    private SposobLeczeniaRepository sposobLeczeniaRepository;

    public SpecyfikController(SpecyfikRepository specyfikRepository) {
        this.specyfikRepository = specyfikRepository;
        this.sposobLeczeniaRepository = sposobLeczeniaRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("specyfiki", specyfikRepository.findAll());
        return "home";
    }

    @GetMapping("/specyfik/dodaj")
    public String addForm(Model model) {
        model.addAttribute("sposobLeczenia", sposobLeczeniaRepository.findAll());
        model.addAttribute("specyfik", new Specyfik());
        return "dodajSpecyfik";
    }

    @PostMapping("/specyfik/dodaj")
    public String add(Specyfik specyfik) {
        specyfikRepository.save(specyfik);
        return "redirect:/";
    }

    @GetMapping("/specyfik/{id}")
    public String specyfik(@PathVariable Long id, Model model) {
        Optional<Specyfik> specyfikOptional = specyfikRepository.findById(id);

        if (specyfikOptional.isPresent()) {
            model.addAttribute("specyfik", specyfikOptional.get());
            return "specyfik";
        } else {
            return "error";
        }
    }
}
