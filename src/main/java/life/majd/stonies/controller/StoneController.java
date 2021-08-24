package life.majd.stonies.controller;

import life.majd.stonies.domain.Comment;
import life.majd.stonies.domain.Stone;
import life.majd.stonies.service.StoneService;
import life.majd.stonies.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stone")
@RequiredArgsConstructor
public class StoneController {

    private final StoneService stoneService;
    private final JwtUtil jwtUtil;

    @GetMapping
    public List<Stone> getAllStone() {
        return stoneService.getAllStones();
    }

    @PostMapping
    public void saveStone(Stone stone) {
        stoneService.addStone(stone);
    }

    @GetMapping("/{id}")
    public Stone getStoneById(@PathVariable String id) {
        return stoneService.getStone(id);
    }

    @PostMapping("/{id}")
    public void addComment(@PathVariable String id, @RequestBody Comment comment) {
        stoneService.addComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteStoneById(@PathVariable String id) {
        stoneService.deleteStone(id);
    }

    @PostMapping("/{stoneId}/upvote")
    public void upVoteStone(@PathVariable String stoneId) {
        String currentUsername = jwtUtil.getCurrentUsername();
        stoneService.upVoteStoneById(stoneId, "userId");
    }

    @PostMapping("/{stoneId}/downvote")
    public void downVoteStone(@PathVariable String stoneId) {
        String currentUsername = jwtUtil.getCurrentUsername();
        stoneService.downVoteStoneById(stoneId, currentUsername);
    }


}
