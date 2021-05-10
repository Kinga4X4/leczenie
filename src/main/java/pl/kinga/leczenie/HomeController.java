package pl.kinga.leczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kinga.leczenie.specyfik.SpecyfikRepository;
import pl.kinga.leczenie.sposobleczenia.SposobLeczenia;

@Controller
public class HomeController {

    @Autowired
    private SpecyfikRepository specyfikRepository;
    private SposobLeczenia sposobLeczenia;

    public HomeController(SpecyfikRepository specyfikRepository) {
        this.specyfikRepository = specyfikRepository;
    }

    public HomeController(SposobLeczenia sposobLeczenia) {
        this.sposobLeczenia = sposobLeczenia;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("specyfiki", specyfikRepository.findAll());
        return "home";
    }
}
