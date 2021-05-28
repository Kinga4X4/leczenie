package pl.kinga.treatment.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kinga.treatment.user.User;
import pl.kinga.treatment.user.UserService;

import java.util.Optional;

@Controller
public class AdminController {
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String modify(@PathVariable Long id, Model model) {
        Optional<User> optionalById = userService.findById(id);
        if (optionalById.isPresent()) {
            User user = optionalById.get();
            model.addAttribute("user", user);
            return "modify";
        } else return "error";
    }

    @PostMapping("/user/modify")
    public String modifyUser(User user) {
        userService.save(user);
        return "redirect:/user";
    }
}



