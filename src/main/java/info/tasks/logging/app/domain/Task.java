package info.tasks.logging.app.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long taskId;

  @Column(name = "task_name")
  private String taskName;

  @Column(name = "time_spent_on_task")
  private Date timeSpentOnTask;

  @Column(name = "task_group")
  private String taskGroup;

  @Column(name = "assignee")
  private String assignee;

  @Column(name = " flag_if_the_task_is_finished")
  private String status;

  public Task() {
  }

  public Task(String taskName) {
    this.taskName = taskName;
  }

  public Task(Long taskId, String taskName, Date timeSpentOnTask, String taskGroup, String assignee, String status) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.timeSpentOnTask = timeSpentOnTask;
    this.taskGroup = taskGroup;
    this.assignee = assignee;
    this.status = status;
  }

  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public Date getTimeSpentOnTask() {
    return timeSpentOnTask;
  }

  public void setTimeSpentOnTask(Date timeSpentOnTask) {
    this.timeSpentOnTask = timeSpentOnTask;
  }

  public String getTaskGroup() {
    return taskGroup;
  }

  public void setTaskGroup(String taskGroup) {
    this.taskGroup = taskGroup;
  }

  public String getAssignee() {
    return assignee;
  }

  public void setAssignee(String assignee) {
    this.assignee = assignee;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
