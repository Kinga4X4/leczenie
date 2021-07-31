package pl.kinga.treatment.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kinga.treatment.treatment_way.TreatmentWay;

import java.util.Optional;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user/add")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/user/add")
    public String addForm(User user) {
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/modifyLoggedUser")
    public String modifyLogged(User user, Model model) {
        model.addAttribute("users", userService.findAll());
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/modifyLoggedUser/{id}")
    public String modifyLoggedUser(@PathVariable Long id, Model model) {
        Optional<User> optionalById = userService.findById(id);
        if (optionalById.isPresent()) {
            User user = optionalById.get();
            model.addAttribute("user", user);
            return "modifyLoggedUser";
        } else return "error";
    }
}
