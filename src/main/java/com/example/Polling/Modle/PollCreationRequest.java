package com.example.Polling.Modle;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class PollCreationRequest {
    private String question;
    private List<String> choices;


}
