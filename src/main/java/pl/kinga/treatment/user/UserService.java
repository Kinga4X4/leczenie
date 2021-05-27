package pl.kinga.treatment.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kinga.treatment.user.User;
import pl.kinga.treatment.user.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void registerUser(String userName, String rawPassword) {

        User userToAdd = new User();
        userToAdd.setUserName(userName);
        String encryptedPassword = passwordEncoder.encode(rawPassword);
        List<UserRole> list = Arrays.asList(new UserRole(Role.ROLE_USER, userToAdd));
        userToAdd.setRoles(new HashSet<>(list));
        userToAdd.setPassword(encryptedPassword);
        userRepository.save(userToAdd);
    }
}

