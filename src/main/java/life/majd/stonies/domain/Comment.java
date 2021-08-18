package life.majd.stonies.domain;

import java.time.LocalDateTime;

public class Comment {

    private String authorId;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

}
