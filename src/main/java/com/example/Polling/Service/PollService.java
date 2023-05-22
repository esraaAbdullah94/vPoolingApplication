package com.example.Polling.Service;

import com.example.Polling.DTO.PollCreationDto;
import com.example.Polling.DTO.PollResultDto;
import com.example.Polling.Modle.Poll;
import com.example.Polling.Modle.PollChoice;
import com.example.Polling.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;


    public void createPoll(PollCreationDto pollDto) {
        Poll poll = new Poll();
        poll.setQuestion(pollDto.getQuestion());

        List<PollChoice> choices = new ArrayList<>();
        for (String choice : pollDto.getChoices()) {
            PollChoice pollChoice = new PollChoice();
            pollChoice.setChoice(choice);
            pollChoice.setVotes(0);
            pollChoice.setPoll(poll);
            pollChoice.setIsActive(true);
            choices.add(pollChoice);
        }

        poll.setChoices(choices);

        pollRepository.save(poll);
    }

    //////////////
    public void voteOnPoll(Long pollId, String choice) {
        Optional<Poll> optionalPoll = pollRepository.findById(pollId);
        if (optionalPoll.isPresent()) {
            Poll poll = optionalPoll.get();
            List<PollChoice> choices = poll.getChoices();

            for (PollChoice pollChoice : choices) {
                if (pollChoice.getChoice().equals(choice)) {
                    pollChoice.setVotes(pollChoice.getVotes() + 1);
                    break;
                }
            }

            pollRepository.save(poll);
        } else {
            throw new IllegalArgumentException("Poll not found with ID: " + pollId);
        }
    }

    public PollResultDto getPollResults(Long pollId) {
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poll not found with id: " + pollId));

        List<PollChoice> choices = poll.getChoices();

        Map<String, Integer> results = new HashMap<>();
        int totalVotes = 0;

        for (PollChoice choice : choices) {
            int votes = choice.getVotes();
            results.put(choice.getChoice(), votes);
            totalVotes += votes;
        }

        return new PollResultDto(poll.getQuestion(), results, totalVotes);
    }
    public void deletePollByID(Long id) {
        Poll pollToDelete = pollRepository.findById(id).get();
    }
}





