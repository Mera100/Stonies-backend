package life.majd.stonies.domain;

import org.springframework.data.annotation.Id;

public class Role {

    @Id
    private String id;
    private String roleName;
}
