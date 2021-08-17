package info.tasks.logging.app.service;

import info.tasks.logging.app.domain.Task;
import info.tasks.logging.app.repository.TaskRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public TaskService () {}

  public List<Task> getTasks() {
    return taskRepository.findAll();
  }

  public Task getTaskById(Long taskId) {
    return taskRepository.findById(taskId).orElseThrow(RuntimeException::new);
  }

  public Task createTask(Task Task) {
    return taskRepository.save(Task);
  }

  public Task updateTask(Task task) {
    Task oldTask = taskRepository.findById(task.getTaskId()).orElse(null);
    assert oldTask != null;
    oldTask.setTaskName(task.getTaskName());
    oldTask.setTimeSpentOnTask(task.getTimeSpentOnTask());
    oldTask.setTaskGroup(task.getTaskGroup());
    oldTask.setAssignee(task.getAssignee());
    oldTask.setStatus(task.getStatus());
    return taskRepository.save(oldTask);
  }

  public Long deleteTask(Long taskId) {
    taskRepository.deleteById(taskId);
    return taskId;
  }

}
