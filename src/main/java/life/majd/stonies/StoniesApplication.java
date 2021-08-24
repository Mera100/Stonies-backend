package life.majd.stonies;

import life.majd.stonies.domain.Comment;
import life.majd.stonies.domain.Role;
import life.majd.stonies.domain.Stone;
import life.majd.stonies.domain.User;
import life.majd.stonies.repository.RoleRepository;
import life.majd.stonies.service.StoneService;
import life.majd.stonies.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static java.time.LocalDateTime.now;

@SpringBootApplication
public class StoniesApplication {

    public static void main(String[] args) {

        SpringApplication.run(StoniesApplication.class, args);

    }

    @Bean
    CommandLineRunner runner(StoneService stoneService, RoleRepository roleRepository, UserService userService, MongoTemplate mongoTemplate) {
        return args -> {
            mongoTemplate.getDb().drop();
            Role roleAdmin = new Role(null, "ROLE_ADMIN");
            Role roleModerator = new Role(null, "ROLE_MODERATOR");
            Role roleUser = new Role(null, "ROLE_USER");
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
            roleRepository.save(roleModerator);
            userService.addUser(new User(null, "majd.hasan@hotmail.com", "majdhasan", "pass", new HashSet<>(), new HashSet<>(), now(), new ArrayList<>()));
            userService.addUser(new User(null, "mido@hotmail.com", "mido", "pass", new HashSet<>(), new HashSet<>(), now(), new ArrayList<>()));
            Comment comment = new Comment(null, "authorId", "Comment title", "This is the content of a comment", now());
            Comment comment1 = new Comment(null, "authorId", "Comment title", "This is the content of a comment", now());
            Comment comment2 = new Comment(null, "authorId", "Comment title", "This is the content of a comment", now());
            Stone stone = stoneService.addStone(new Stone(null, "title", "content", 12.44444, 12.234234, 10, new ArrayList<>(), LocalDate.now(), now(), "author", "imageUrl", null));
            userService.addRoleToUser("ROLE_ADMIN", "majdhasan");
            userService.addRoleToUser("ROLE_ADMIN", "mido");
            stoneService.addComment(stone.getId(), comment);
            stoneService.addComment(stone.getId(), comment1);
            stoneService.addComment(stone.getId(), comment2);
        };
    }
}
