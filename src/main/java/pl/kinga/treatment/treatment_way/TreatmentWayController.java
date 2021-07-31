package pl.kinga.treatment.treatment_way;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.kinga.treatment.user.User;


import java.util.Optional;

@Controller
public class TreatmentWayController {

    private TreatmentRepository treatmentRepository;

    public TreatmentWayController(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/treatmentMethod")
    public String treatmentMethod(Model model) {
        model.addAttribute("treatmentWay", treatmentRepository.findAll());
        return "treatmentMethod";
    }

    @GetMapping("/treatmentWay/{id}")
    public String treatmentWay(@PathVariable Long id, Model model) {
        Optional<TreatmentWay> treatmentWayOptional = treatmentRepository.findById(id);
        if (treatmentWayOptional.isPresent()) {
            TreatmentWay treatmentWay = treatmentWayOptional.get();
            model.addAttribute("treatmentWay", treatmentWay);
            return "treatmentWay";
        } else {
            return "error";
        }
    }

    @GetMapping("/treatmentWay/delete/{id}")
    public String delete(@PathVariable Long id) {
        treatmentRepository.deleteById(id);
        return "redirect:/";
    }

}