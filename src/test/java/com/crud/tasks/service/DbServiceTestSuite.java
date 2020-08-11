package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    private DbService dbService;

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task("test_task", "test_content");
        int taskQty = dbService.getAllTasks().size();

        //When
        dbService.saveTask(task);
        int taskQtyAfterSaving = dbService.getAllTasks().size();

        //Then
        assertEquals(taskQty + 1, taskQtyAfterSaving);
        assertEquals(Optional.of(task), dbService.getTask(task.getId()));
    }

    @Test
    public void testDeleteTask() {
        //Given
        Task task = new Task("test_task", "test_content");
        dbService.saveTask(task);
        int taskQty = dbService.getAllTasks().size();

        //When
        dbService.deleteTask(task.getId());
        int taskQtyAfterDel = dbService.getAllTasks().size();

        //Then
        assertEquals(taskQty - 1, taskQtyAfterDel);
        assertEquals(Optional.empty(), dbService.getTask(task.getId()));
    }
}
