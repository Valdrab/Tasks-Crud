package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "trello list", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "trello list 2", true);
        List<TrelloListDto> trelloListDtos1 = new ArrayList<>();
        List<TrelloListDto> trelloListDtos2 = new ArrayList<>();
        trelloListDtos1.add(trelloListDto1);
        trelloListDtos2.add(trelloListDto2);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "trello board", trelloListDtos1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "trello board 2", trelloListDtos2);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);

        //When
        List<TrelloBoard> mappedBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals("1", mappedBoards.get(0).getId());
        assertEquals("2", mappedBoards.get(1).getId());
        assertEquals("trello board", mappedBoards.get(0).getName());
        assertEquals(1, mappedBoards.get(0).getLists().size());
        assertFalse(mappedBoards.get(0).getLists().get(0).isClosed());
        assertTrue(mappedBoards.get(1).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "trello list", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("1", "trello board", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoardDto> mappedBoardsDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals("1", mappedBoardsDtos.get(0).getId());
        assertEquals("trello board", mappedBoardsDtos.get(0).getName());
        assertEquals(1, mappedBoardsDtos.get(0).getLists().size());
        assertTrue(mappedBoardsDtos.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "trello list", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals("1", trelloLists.get(0).getId());
        assertEquals("trello list", trelloLists.get(0).getName());
        assertFalse(trelloLists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "trello list", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals("1", trelloListDtos.get(0).getId());
        assertEquals("trello list", trelloListDtos.get(0).getName());
        assertTrue(trelloListDtos.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("trello card", "card desc.", "top", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("trello card", trelloCardDto.getName());
        assertEquals("card desc.", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("trello card", "card desc.", "top", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("trello card", trelloCard.getName());
        assertEquals("card desc.", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }
}
