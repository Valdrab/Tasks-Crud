package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test_task", "test_content");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(new Long(1L), mappedTask.getId());
        assertEquals("test_task", mappedTask.getTitle());
        assertEquals("test_content", mappedTask.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test_task", "test_content");

        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, mappedTask.getId());
        assertEquals("test_task", mappedTask.getTitle());
        assertEquals("test_content", mappedTask.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "test_task", "test_content");
        Task task2 = new Task(2L, "test_task2", "test_content2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1L, taskDtos.get(0).getId());
        assertEquals("test_task2", taskDtos.get(1).getTitle());
        assertEquals(2, taskDtos.size());
    }
}
