package life.majd.stonies.service;

import life.majd.stonies.domain.Role;
import life.majd.stonies.domain.User;
import life.majd.stonies.exceptions.UserAlreadyExistsException;
import life.majd.stonies.repository.RoleRepository;
import life.majd.stonies.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        User byUsername = userRepository.findByUsername(user.getUsername()).orElse(null);
        User byEmail = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (byUsername == null && byEmail == null) {
            User savedUser = userRepository.save(user);
            log.info("New User {} with username {} and Email {} has been created",
                    savedUser.getId(),
                    savedUser.getUsername(),
                    savedUser.getEmail());
            return savedUser;
        }
        throw new UserAlreadyExistsException("A user with either this email or the username already exist in the system");
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void deleteUser(String username) {
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addRoleToUser(String roleName, String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        Role role = roleRepository.findByRoleName(roleName).orElse(null);
        if (role == null || user == null) {
            throw new NoSuchElementException("User or Role couldn't be found");
        }
        log.info("New Role {} has been added to {}",
                role.getRoleName(),
                user.getUsername());
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
