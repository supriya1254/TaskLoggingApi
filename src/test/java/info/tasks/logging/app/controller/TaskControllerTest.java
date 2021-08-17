package info.tasks.logging.app.controller;

import info.tasks.logging.app.service.TaskService;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
@DisplayName("Task Controller Test")
class TaskControllerTest extends TestCase {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TaskService taskService;



}