package life.majd.stonies.service;

import life.majd.stonies.domain.Comment;
import life.majd.stonies.domain.Stone;
import life.majd.stonies.domain.User;
import life.majd.stonies.repository.StoneRepository;
import life.majd.stonies.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class StoneServiceImpl implements StoneService {

    private final StoneRepository stoneRepository;
    private final UserRepository userRepository;

    @Override
    public Stone addStone(Stone stone) {
        log.info("a new Stone has been saved.");
        return stoneRepository.save(stone);
    }

    @Override
    public Stone getStone(String stoneId) {
        return getStoneById(stoneId);
    }


    @Override
    public List<Stone> getAllStones() {
        return stoneRepository.findAll();
    }

    @Override
    public void deleteStone(String stoneId) {
        Stone stone = getStoneById(stoneId);
        if (stone != null) {
            log.info("Stone with ID: {} has been deleted", stone.getId());
            stoneRepository.delete(stone);
        }
        log.warn("Stone with ID: {} could not be found", stoneId);
    }

    @Override
    public List<Comment> getComments(String stoneId) {

        Stone stone = getStoneById(stoneId);
        if (stone != null) {
            return stone.getComments();
        }
        log.warn("Stone with ID: {} could not be found", stoneId);
        return null;
    }

    @Override
    public void addComment(String stoneId, Comment comment) {

        Stone stone = getStoneById(stoneId);
        if (stone != null) {
            stone.getComments().add(comment);
            stoneRepository.save(stone);
        } else {
            log.warn("Stone with ID: {} could not be found", stoneId);
        }
    }

    public void upVoteStoneById(String stoneId, String username) {
        Stone stone = getStoneById(stoneId);
        User user = getUserByUsername(username);
        if (stone != null && user != null
                && !user.getUpVotedStones().contains(stoneId)
                && !user.getDownVotedStones().contains(stoneId)) {
            stone.setRating(stone.getRating() + 1);
            user.getUpVotedStones().add(stoneId);
            userRepository.save(user);
            stoneRepository.save(stone);
            log.info("Stone with the id {} has been upvoted by {}", stoneId, username);
        } else {
            log.warn("stoneId or username couldn't be found");
        }
    }

    public void downVoteStoneById(String stoneId, String username) {
        Stone stone = getStoneById(stoneId);
        User user = getUserByUsername(username);

        if (stone != null && user != null
                && !user.getUpVotedStones().contains(stoneId)
                && !user.getDownVotedStones().contains(stoneId)) {
            stone.setRating(stone.getRating() + 1);
            user.getDownVotedStones().add(stoneId);
            userRepository.save(user);
            stoneRepository.save(stone);
            log.info("Stone with the id {} has been downvoted by {}", stoneId, username);
        } else {
            log.warn("stoneId or username couldn't be found");
        }
    }

    private Stone getStoneById(String id) {
        return stoneRepository.findById(id).orElse(null);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
