package com.example.Polling.Repository;


import com.example.Polling.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {

}