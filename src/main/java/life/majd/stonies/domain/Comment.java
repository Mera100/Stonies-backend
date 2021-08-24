package life.majd.stonies.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    private String id;
    private String authorUsername;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

}
