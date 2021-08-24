package life.majd.stonies.domain;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import static java.time.LocalDateTime.now;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private Set<String> upVotedStones;
    private Set<String> downVotedStones;
    private LocalDateTime joinedAt = now();
    private ArrayList<Role> roles = new ArrayList();
}
