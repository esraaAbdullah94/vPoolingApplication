package com.example.Polling.Repository;

import com.example.Polling.Modle.Poll;
import com.example.Polling.Modle.PollChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
//    @Query(value = "SELECT p FROM Polls p where p.id= :id")
//    Poll deletePollByID(@Param("id") Integer id);

    @Query("SELECT p from PollChoice p")
    List<PollChoice> getPollReport();
}
