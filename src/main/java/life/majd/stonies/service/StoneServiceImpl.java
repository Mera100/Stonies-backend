package life.majd.stonies.service;

import life.majd.stonies.domain.Stone;
import life.majd.stonies.repository.StoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class StoneServiceImpl implements StoneService {

    private final StoneRepository stoneRepository;

    @Override
    public void addStone(Stone stone) {
        stoneRepository.save(stone);
    }

    @Override
    public Stone getStone(String stoneId) {
        return stoneRepository.findById(stoneId).orElse(null);
    }

    // @TODO Mido please finish this methode
    // @fixme please fix this shit
    @Override
    public List<Stone> getAllStones() {
        return stoneRepository.findAll();

    }

    @Override
    public void deleteStone(String stoneID) {
        Stone stone = stoneRepository.findById(stoneID).orElse(null);
        if (stone != null) {
            stoneRepository.delete(stone);
        }
    }
}
