package info.tasks.logging.app.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import info.tasks.logging.app.domain.Task;
import info.tasks.logging.app.repository.TaskRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DisplayName("TaskService Test")
class TaskServiceTest {

  @Autowired
  private TaskService taskService;

  @MockBean
  private TaskRepository taskRepository;

  private void setUpMocks() {
    Task task = new Task();
    task.setTaskId(1L);
    task.setTaskName("testName");
    task.setTimeSpentOnTask(new Date());
    task.setTaskGroup("testGroup");
    task.setAssignee("testAssignee");
    task.setStatus("active");
    List<Task> taskList = new ArrayList<>();
    taskList.add(task);
    when(taskRepository.save(any())).thenReturn(task);
    when(taskRepository.findAll()).thenReturn(taskList);
    when(taskRepository.findById(any())).thenReturn(Optional.of(task));
  }


// POST method
  @Test
  @DisplayName("create task with test data")
  void shouldCreateTask() {
    setUpMocks();
    Task createTask = new Task();
    createTask.setTaskName("firstTask");
    Task task = taskService.createTask(createTask);

    assertNotNull(task);
  }

  // GET method
  @Test
  @DisplayName("retrieve task by id")
  void shouldRetrieveTaskById() {
    setUpMocks();
    Task createTask = new Task();
    createTask.setTaskId(1L);
    createTask.setTaskName("firstTask");
    Task task = taskService.createTask(createTask);

    Task foundTask = taskService.getTaskById(1L);

    assertNotNull(foundTask);
    assertEquals(task.getTaskId(), foundTask.getTaskId());
  }

  //GET method
  @Test
  @DisplayName("retrieve all task")
  void shouldRetrieveAllTask() {
    setUpMocks();
    List<Task> taskList = taskService.getTasks();
    assertEquals(1,taskList.size());
  }

  //DELETE method
  @Test
  @DisplayName("delete task by id")
  void shouldDeleteTask() {
    setUpMocks();
    assertDoesNotThrow(() ->taskService.deleteTask(1L));
    verify(taskRepository, times(1)).deleteById(any());
  }

}