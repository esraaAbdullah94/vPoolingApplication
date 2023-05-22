package com.example.Polling.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PollVoteDto {

    private String choice;
    public PollVoteDto() {
        // Default constructor required for deserialization

    }
    public PollVoteDto(String choice) {
        this.choice = choice;
    }


}
