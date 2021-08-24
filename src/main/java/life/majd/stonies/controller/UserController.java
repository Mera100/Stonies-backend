package life.majd.stonies.controller;

import life.majd.stonies.domain.User;
import life.majd.stonies.exceptions.UserAlreadyExistsException;
import life.majd.stonies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    User getUserByUsername(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    User addUser(User user) throws UserAlreadyExistsException {
        return userService.addUser(user);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @PostMapping("/addRole")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void addRoleToUser(@RequestBody String roleName, @RequestBody String username) {
        userService.addRoleToUser(roleName, username);
    }


}
