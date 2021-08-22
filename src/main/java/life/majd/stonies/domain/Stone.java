package life.majd.stonies.domain;


import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stone {

    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private double latitude;
    @NonNull
    private double longitude;
    private Integer rating;
    private List<Comment> comments;
    private LocalDate happendAt;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String authorId;
    private String imageUrl;
    private Set<String> tags;


}
