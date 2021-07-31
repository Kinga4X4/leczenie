package pl.kinga.treatment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kinga.treatment.user.User;
import pl.kinga.treatment.user.UserService;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(@RequestParam(required = false) String error, Model model) {
        boolean showErrorMessage = false;
        model.addAttribute("showErrorMessage", error != null);
        return "login";
    }

    @PostMapping("/register")
    public String register(User user) {
        String userName = user.getUserName();
        String rawPassword = user.getPassword();
        userService.registerUser(user, user.getPassword());
        return "registerSuccess";
    }
}
