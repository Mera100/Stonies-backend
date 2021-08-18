package life.majd.stonies.repository;

import life.majd.stonies.domain.Stone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoneRepository extends MongoRepository<Stone, String> {


}
