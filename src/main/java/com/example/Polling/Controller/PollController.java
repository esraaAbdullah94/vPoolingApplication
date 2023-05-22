package com.example.Polling.Controller;

import com.example.Polling.DTO.PollCreationDto;
import com.example.Polling.DTO.PollResultDto;
import com.example.Polling.DTO.PollVoteDto;
import com.example.Polling.Service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/polls")
public class PollController {
     @Autowired
     PollService pollService;



    @PostMapping("/polls")
    public ResponseEntity<String> createPoll(@RequestBody PollCreationDto pollDto) {
        pollService.createPoll(pollDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Poll created successfully");
    }

    @PostMapping("/{pollId}/vote")
    public ResponseEntity<String> voteOnPoll(@PathVariable Long pollId, @RequestBody PollVoteDto voteDto) {
        pollService.voteOnPoll(pollId, voteDto.getChoice());
        return ResponseEntity.ok("Vote recorded successfully");
    }
    @GetMapping("/{pollId}")
    public ResponseEntity<PollResultDto> getPollResults(@PathVariable Long pollId) {
        PollResultDto pollResult = pollService.getPollResults(pollId);
        return ResponseEntity.ok(pollResult);
    }
}
