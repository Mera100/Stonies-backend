package life.majd.stonies.service;

import life.majd.stonies.domain.Comment;
import life.majd.stonies.domain.Stone;

import java.util.List;

public interface StoneService {

    Stone addStone(Stone stone);

    Stone getStone(String stoneId);

    List<Stone> getAllStones();

    void deleteStone(String stoneID);

    List<Comment> getComments(String stoneId);

    void addComment(String stoneId, Comment comment);

    void upVoteStoneById(String stoneId, String userId);

    void downVoteStoneById(String stoneId, String userId);


}
