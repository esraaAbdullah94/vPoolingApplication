package com.example.Polling.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
public class PollResultDto {
    private String question;
    private Map<String, Integer> results;
    private int totalVotes;

    public PollResultDto(String question, Map<String, Integer> results, int totalVotes) {
        this.question = question;
        this.results = results;
        this.totalVotes = totalVotes;
    }


}
