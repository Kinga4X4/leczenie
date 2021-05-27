package pl.kinga.treatment.specific;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kinga.treatment.treatment_way.TreatmentWay;
import pl.kinga.treatment.treatment_way.TreatmentRepository;

import java.util.Optional;

@Controller
public class SpecificController {

    TreatmentRepository treatmentRepository;
    SpecificRepository specificRepository;

    public SpecificController(TreatmentRepository treatmentRepository, SpecificRepository specificRepository) {
        this.treatmentRepository = treatmentRepository;
        this.specificRepository = specificRepository;
    }

    @GetMapping("/treatmentWay")
    public String TreatmentMethod(Model model, TreatmentWay treatmentWay) {
        model.addAttribute("specific", specificRepository.findByTreatmentWay(treatmentWay));
        return "treatmentMethod";
    }

    @GetMapping("/specific/add")
    public String addForm(Model model, @RequestParam Long treatmentWayId) {
        Specific specific = new Specific();
        Optional<TreatmentWay> treatmentWayOptional = treatmentRepository.findById(treatmentWayId);
        specific.setTreatmentWay(treatmentWayOptional.orElse(null));
        model.addAttribute("treatmentWay", treatmentRepository.findAll());
        model.addAttribute("specific", new Specific());
        return "addSpecific";
    }

    @PostMapping("/specific/add")
    public String addForm(Specific specific) {
        specificRepository.save(specific);
        return "redirect:/treatmentWay/" + specific.getTreatmentWay().getId();
    }

}
