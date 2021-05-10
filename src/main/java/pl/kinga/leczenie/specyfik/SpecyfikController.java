package pl.kinga.leczenie.specyfik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class SpecyfikController {
    private SpecyfikRepository specyfikRepository;

    public SpecyfikController(SpecyfikRepository specyfikRepository) {
        this.specyfikRepository = specyfikRepository;
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
