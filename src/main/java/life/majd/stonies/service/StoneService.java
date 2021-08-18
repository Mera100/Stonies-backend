package life.majd.stonies.service;

import life.majd.stonies.domain.Stone;

import java.util.List;

public interface StoneService {

    void addStone(Stone stone);

    Stone getStone(String stoneId);

    List<Stone> getAllStones();

    void deleteStone(String stoneID);


}
