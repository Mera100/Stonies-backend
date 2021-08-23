package life.majd.stonies.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String authorId;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

}
