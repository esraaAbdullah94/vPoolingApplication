package com.example.Polling.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportDto {
    public ReportDto(String choice, int votes) {
        this.choice = choice;
        this.votes = votes;
    }

    private String choice;

    private int votes;
}
