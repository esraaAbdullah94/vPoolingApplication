package com.example.Polling.Modle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "poll_choices")
public class PollChoice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Poll poll;

    private String choice;

    private int votes;

    // Constructors, getters, and setters
}
