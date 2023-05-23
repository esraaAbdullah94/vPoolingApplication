package com.example.Polling.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    void testDeleteAllUser() throws Exception {
        String result = userController.deleteAllUser();
        assertEquals("ALL User isActive=false", result);
    }
}