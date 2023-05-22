package com.example.Polling.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class PollCreationDto {

    public PollCreationDto(String question, List<String> choices) {
        this.question = question;
        this.choices = choices;
    }

    private String question;
    private List<String> choices;


}
