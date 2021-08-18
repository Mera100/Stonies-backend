package life.majd.stonies.domain;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.time.LocalDateTime.now;

@Data
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
    private final LocalDateTime joinedAt = now();
    private final ArrayList<Role> roles = new ArrayList();


}
