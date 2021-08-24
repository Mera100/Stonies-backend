package life.majd.stonies.service;

import life.majd.stonies.domain.Role;
import life.majd.stonies.domain.User;
import life.majd.stonies.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserService {

    User addUser(User user) throws UserAlreadyExistsException;

    User getUser(String username);

    void deleteUser(String username);

    List<User> getUsers();

    void addRoleToUser(String roleName, String username);

    List<Role> getRoles();

}
