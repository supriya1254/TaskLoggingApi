package info.tasks.logging.app.controller;

import info.tasks.logging.app.domain.Task;
import info.tasks.logging.app.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TaskController {

  @Autowired
  private TaskService taskService;

    @GetMapping("/")
    public List<Task> getTasks() {
      return taskService.getTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
      return taskService.getTaskById(taskId);
    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task Task) {
      return taskService.createTask(Task);
    }

    @PutMapping("/")
    public Task updateTask(@RequestBody Task task) {
      return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public Long deleteTask(@PathVariable Long taskId) {
      return taskService.deleteTask(taskId);
    }

}
