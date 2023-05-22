package com.example.Polling.Modle;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "polls")
public class Poll extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User createdBy;

    private String question;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<PollChoice> choices;


}


