package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloConfigTestSuite {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void getTrelloApiEndPoint() {
        //When
        String apiEndPoint = trelloConfig.getTrelloApiEndpoint();

        //Then
        assertEquals("https://api.trello.com/1", apiEndPoint);
    }

    @Test
    public void getTrelloUsername() {
        //When
        String apiUsername = trelloConfig.getTrelloUsername();

        //Then
        assertEquals("mateuszzielinski34", apiUsername);
    }

    @Test
    public void getTrelloAppKey() {
        //When
        String trelloAppKey = trelloConfig.getTrelloAppKey();

        //Then
        assertEquals("5d08699d6d87e71499ecf22809a55783", trelloAppKey);
    }
}
