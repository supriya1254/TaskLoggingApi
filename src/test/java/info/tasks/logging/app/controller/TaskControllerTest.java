package info.tasks.logging.app.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import info.tasks.logging.app.domain.Task;
import info.tasks.logging.app.service.TaskService;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
@DisplayName("Task Controller Test")
class TaskControllerTest extends TestCase{

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TaskService taskService;


  @Test
  void getValidTaskByGet() throws Exception {

    Task task = new Task();
    task.setTaskId(1L);
    task.setTaskName("testName");
    task.setTimeSpentOnTask(new Date());
    task.setTaskGroup("testGroup");
    task.setAssignee("testAssignee");
    task.setStatus("active");

    when(taskService.getTaskById(1L)).thenReturn(task);

    RequestBuilder request =
      MockMvcRequestBuilders
        .get("/api/getTask/1")
        .contentType(MediaType.APPLICATION_JSON);

    MvcResult response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().json(
        "{taskId:1,taskName:testName,taskGroup:testGroup,assignee:testAssignee,status:active}"
      ))
      .andReturn();
  }



}