package com.example.Polling.Repository;

import com.example.Polling.Modle.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    @Query(value = "SELECT p FROM Polls p where p.id= :id")
    Poll deletePollByID(@Param("id") Integer id);
}
