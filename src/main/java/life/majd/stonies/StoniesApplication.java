package life.majd.stonies;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import life.majd.stonies.domain.Stone;
import life.majd.stonies.service.StoneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.LocalDateTime.now;

@SpringBootApplication
public class StoniesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoniesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StoneService stoneService) {
        return args -> {
            Stone stone = new Stone(null, "title", "content", 12.44444,12.234234, 10, null, LocalDate.now(), now(), "author", "imageUrl", null);
            stoneService.addStone(stone);
        };
    }

}
