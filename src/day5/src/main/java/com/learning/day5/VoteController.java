package day5.src.main.java.com.learning.day5;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/vote")
@Controller
public class VoteController {

    @GetMapping
    public ResponseEntity<?> vote(@RequestParam String name) {
        if(name == null || name.isEmpty()) {

            ProblemDetail problemDetail = ProblemDetail.forStatus(400);
            problemDetail.setTitle("Bad Request");
            problemDetail.setDetail("Name cannot be null or empty");
            problemDetail.setProperty("name", name);
            problemDetail.setProperty("possibleNames", List.of("Java", "Python"));

            return ResponseEntity.badRequest().body(problemDetail);
        }
        return ResponseEntity.ok("Voted for: " + name);
    }

    @GetMapping
    public ResponseEntity<?> voteVersion2(@RequestParam String name) {
        if(name == null || name.isEmpty()) {

            ProblemDetail problemDetail = ProblemDetail.forStatus(400);
            problemDetail.setTitle("Bad Request");
            problemDetail.setDetail("Name cannot be null or empty");
            problemDetail.setProperty("name", name);
            problemDetail.setProperty("possibleNames", List.of("Java", "Python"));

            return ResponseEntity.badRequest().body(problemDetail);
        }
        return ResponseEntity.ok("Voted for: " + name);
    }

}
