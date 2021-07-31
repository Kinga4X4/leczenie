package pl.kinga.treatment.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kinga.treatment.user.User;
import pl.kinga.treatment.user.UserRepository;
import pl.kinga.treatment.user.UserRole;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class MyUserDetailsSevice implements UserDetailsService {
    private UserRepository userRepository;

    public MyUserDetailsSevice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByUserName(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Set<SimpleGrantedAuthority> roles = user.getRoles()
                    .stream()
                    .map(userRole -> new SimpleGrantedAuthority(userRole.getRole().name()))
                    .collect(Collectors.toSet());
            Collection<SimpleGrantedAuthority> role;
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("UserName" + username + " not found");
    }
}
