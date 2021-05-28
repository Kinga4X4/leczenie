package pl.kinga.treatment.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kinga.treatment.user.User;
import pl.kinga.treatment.user.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public void registerUser(User user, String password) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setRoles(Set.of(new UserRole(Role.ROLE_USER, user)));
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

}

